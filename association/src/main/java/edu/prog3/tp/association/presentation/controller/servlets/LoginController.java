package edu.prog3.tp.association.presentation.controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import edu.prog3.tp.association.bean.Adherent;
import edu.prog3.tp.association.bean.Commande;
import edu.prog3.tp.association.presentation.controller.services.LoginService;
import edu.prog3.tp.association.presentation.controller.services.OrderService;
import edu.prog3.tp.association.presentation.controller.servlets.AccueilController;
import edu.prog3.tp.association.presentation.controller.servlets.validator.FormValidator;


/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet implements FormValidator{
	private static final long serialVersionUID = 1L;
    private static final String ATT_PASSWORD = "mdp";
    private static final String ATT_LOGIN = "id";
    private static final String LOGIN_FORM_VIEW = "/WEB-INF/login.jsp";
    private static final String HOME_PAGE = "/accueil";
    private static final String LOGIN_PAGE = "/login";
    private static final String SESSION_LOGIN_ERROR = "login_error";
    private static final String SESSION_LOGIN = "adherent";
    private static final String INVALID_ID_ERROR_MESSAGE = "L'id est invalid";
    private static final String INVALID_PASSWORD_ERROR_MESSAGE = "L'id est invalid";
    private static final String BAD_LOGIN_ERROR_MESSAGE = "Les données de connexion sont invalides";
    private static final String SESSION_ORDER_ATT = "order";
	private static final String SESSION_PRICE_ATT = "total";
	private static final String SESSION_ARTICLES_ATT = "articles";

    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute(AccueilController.ADHERENT_ATT) != null){
			Adherent adh = (Adherent) session.getAttribute(AccueilController.ADHERENT_ATT);
			log(adh.getId() + " : is disconnected at " + new Date());
			//suppression des session et suppression des items commandé
			if (session.getAttribute(SESSION_ORDER_ATT) != null) {
				Commande order = (Commande) session.getAttribute(SESSION_ORDER_ATT);
				OrderService.removeOrder(order);
				log("order cancel | cause : user disconnected");
				session.removeAttribute(SESSION_ORDER_ATT);
				session.removeAttribute(SESSION_ARTICLES_ATT);
				session.removeAttribute(SESSION_PRICE_ATT);
			}
			session.removeAttribute(AccueilController.ADHERENT_ATT);
			//forwarding
			response.sendRedirect(getServletContext().getContextPath() + LOGIN_PAGE);
			return;
		}		
		else{
			getServletContext().getRequestDispatcher(LOGIN_FORM_VIEW).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//check if entry data are ok
		if(!isValid(request, session)){
			getServletContext().getRequestDispatcher(LOGIN_FORM_VIEW).forward(request, response); 
			return;
		}
		String id = request.getParameter(ATT_LOGIN);
		String password = request.getParameter(ATT_PASSWORD);
		
		Adherent adh = LoginService.login(id, DigestUtils.md5Hex(password));
		if(adh == null) {
			ArrayList<String> errorList = (ArrayList<String>) session.getAttribute(SESSION_LOGIN_ERROR);
			errorList.add(BAD_LOGIN_ERROR_MESSAGE);
			session.setAttribute(SESSION_LOGIN_ERROR, errorList);
			System.out.println(errorList);
			
			getServletContext().getRequestDispatcher(LOGIN_FORM_VIEW).forward(request, response);
			return;
		}
		session.setAttribute(SESSION_LOGIN, adh);
		log(adh.getId() + " : is logged at " + new Date());
		//all is ok redirect user to home
		response.sendRedirect(getServletContext().getContextPath() + HOME_PAGE);
	}
	
	/**
	 * @see FormValidator#isValid(HttpServletRequest request, HttpServletResponse response)
	 */
	public boolean isValid(HttpServletRequest request, HttpSession session){
		String id = request.getParameter(ATT_LOGIN);
		String password = request.getParameter(ATT_PASSWORD);
		ArrayList<String> errorList = new ArrayList<String>();
		//CHECK IF SESSION ERROR ALREADY EXIST / IF EXIST REMOVE IT
		if(session.getAttribute(SESSION_LOGIN_ERROR) != null){
			session.removeAttribute(SESSION_LOGIN_ERROR);
		}
		
		//CHECK FORM INPUT
		if(id==null || id.length() != 8){
			errorList.add(INVALID_ID_ERROR_MESSAGE);
		}
		if(password==null){
			errorList.add(INVALID_PASSWORD_ERROR_MESSAGE);
		}
		session.setAttribute(SESSION_LOGIN_ERROR, errorList);
		System.out.println(errorList);

		return errorList.isEmpty();	
	}

}

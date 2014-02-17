package edu.prog3.tp.association.presentation.controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import edu.prog3.tp.association.bean.Adherent;
import edu.prog3.tp.association.persistence.PersistenceServiceProvider;
import edu.prog3.tp.association.persistence.services.AdherentPersistence;
import edu.prog3.tp.association.presentation.controller.servlets.validator.FormValidator;

/**
 * Servlet implementation class Register
 */
public class RegisterController extends HttpServlet implements FormValidator{
	private static final long serialVersionUID = 1L;
	private static final String ID_ATT = "id";
    private static final String MDP_ATT = "mdp";
    private static final String MDP_CONFIRM_ATT = "mdp2";
    private static final String NAME_ATT = "name";
    private static final String VILLE_ATT = "ville";
    private static final String FIRST_NAME_ATT = "fname";
    private static final String ADRESSE_ATT = "adresse";
    private static final String CP_ATT = "cp";
    private static final String PAYS_ATT = "pays";
    private static final String SESSION_REGISTER_ERROR = "signin_error";
    private static final String ID_ALREADY_EXIST_ERROR_MESSAGE = "L'id est déjà pris";
    private static final String INVALID_PASSWORD_ERROR_MESSAGE = "le mdp ne correspond pas";
    private static final String MISSING_DATA_ERROR_MESSAGE = "Certains champs non pas été remplis";
    private static final String REGISTER_FORM_VIEW = "/WEB-INF/register.jsp";
	public static final String ADHERENT_ATT = "adherent";
	private static final String BAD_ID_ERROR_MESSAGE = "ID TROP COURT";



       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(REGISTER_FORM_VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (!isValid(request, session)) {
			getServletContext().getRequestDispatcher(REGISTER_FORM_VIEW).forward(request, response); 
			return;
		}
		//bind parameters value 
		Adherent adh = bindParameters(request);
		//insert new adh
		PersistenceServiceProvider.getService(AdherentPersistence.class).insert(adh);
		session.setAttribute(ADHERENT_ATT, adh);
		getServletContext().getNamedDispatcher("AccueilController").forward(request, response); 

	}
	
	
	public boolean isValid(HttpServletRequest request, HttpSession session) {
		String id = request.getParameter(ID_ATT);
		String password = request.getParameter(MDP_ATT);
		String password2 = request.getParameter(MDP_CONFIRM_ATT);
		String name = request.getParameter(NAME_ATT);
		String firstName = request.getParameter(FIRST_NAME_ATT);
		String adresse = request.getParameter(ADRESSE_ATT);
		String cp = request.getParameter(CP_ATT);
		String pays = request.getParameter(PAYS_ATT);
		String ville = request.getParameter(VILLE_ATT);

		ArrayList<String> errorList = new ArrayList<String>();

		//CHECK IF SESSION ERROR ALREADY EXIST / IF EXIST REMOVE IT
		if(session.getAttribute(SESSION_REGISTER_ERROR) != null){
			session.removeAttribute(SESSION_REGISTER_ERROR);
		}
		if(id==null || password==null || password2==null || name==null || firstName==null ||adresse==null || ville==null ||cp==null || pays==null){
			errorList.add(MISSING_DATA_ERROR_MESSAGE);
		}
		if(id.length()<8){
			errorList.add(BAD_ID_ERROR_MESSAGE);
		}
		if(!password.equals(password2)){
			errorList.add(INVALID_PASSWORD_ERROR_MESSAGE);
		}
		if(PersistenceServiceProvider.getService(AdherentPersistence.class).load(id)!=null){
			errorList.add(ID_ALREADY_EXIST_ERROR_MESSAGE);
		}

		session.setAttribute(SESSION_REGISTER_ERROR, errorList);
		return errorList.isEmpty();	
	}
	
	/**
	 * Bind request parameter to a new adherent
	 * @param request
	 * @return
	 */
	private Adherent bindParameters(HttpServletRequest request){
		Adherent adh = new Adherent();
		adh.setId(request.getParameter(ID_ATT));
		adh.setMdp(DigestUtils.md5Hex(request.getParameter(MDP_ATT)));
		adh.setNom(request.getParameter(NAME_ATT));
		adh.setPrenom(request.getParameter(FIRST_NAME_ATT));
		adh.setAdresse(request.getParameter(ADRESSE_ATT));
		adh.setCp(request.getParameter(CP_ATT));
		adh.setPays(request.getParameter(PAYS_ATT));
		adh.setVille(request.getParameter(VILLE_ATT));
		return adh;
	}

}

package edu.prog3.tp.association.presentation.controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.prog3.tp.association.bean.Adherent;

/**
 * Servlet implementation class FrontController
 */
public class AccueilController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ADHERENT_ATT = "adherent";
	public static final String DEFAULT_PAGE = "accueil";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilController() {
        super();
        // TODO Auto-generated constructor stub
    }
        
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	/**
	 * Process http request
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        Adherent adh = (Adherent) session.getAttribute(ADHERENT_ATT);
        
        String nextPage = DEFAULT_PAGE;
        // if adherent is null forward to login page
		if(adh==null){
			getServletContext().getNamedDispatcher("LoginController").forward(request, response);
			return;
		}
		System.out.println(nextPage);
		request.setAttribute("page", nextPage);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/template.jsp");
		rd.forward(request, response);
	}

}

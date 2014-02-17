package edu.prog3.tp.association.presentation.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.prog3.tp.association.bean.Adherent;
import edu.prog3.tp.association.presentation.controller.services.OrderService;

/**
 * Servlet implementation class AccountController
 */
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LIST_ORDER_ATT = "history";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		request.setAttribute(LIST_ORDER_ATT, OrderService.listArticlesByAdherent((Adherent) session.getAttribute("adherent")));

		request.setAttribute("page","account");
		getServletContext().getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

package edu.prog3.tp.association.presentation.controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.prog3.tp.association.bean.Article;
import edu.prog3.tp.association.persistence.PersistenceServiceProvider;
import edu.prog3.tp.association.persistence.services.ArticlePersistence;

/**
 * Servlet implementation class ArticleController
 */
public class ArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LIST_ARTICLE_ATT = "articles";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticlePersistence service = PersistenceServiceProvider.getService(ArticlePersistence.class);
		ArrayList<Article> articles = (ArrayList<Article>) service.getArticleInStock(0);
		request.setAttribute(LIST_ARTICLE_ATT, articles);

		request.setAttribute("page","articles");
		getServletContext().getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package edu.prog3.tp.association.presentation.controller.servlets;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.prog3.tp.association.bean.Adherent;
import edu.prog3.tp.association.bean.Article;
import edu.prog3.tp.association.bean.Commande;
import edu.prog3.tp.association.bean.CommandeArticle;
import edu.prog3.tp.association.persistence.PersistenceServiceProvider;
import edu.prog3.tp.association.persistence.services.ArticlePersistence;
import edu.prog3.tp.association.persistence.services.CommandePersistence;
import edu.prog3.tp.association.presentation.controller.services.OrderService;

/**
 * Servlet implementation class OrderController
 */
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String ADD_ARTICLE_ATT = "article";
    private static final String SESSION_ORDER_ATT = "order";
    private static final String SESSION_ARTICLES_ATT = "articles";
    private static final String SESSION_PRICE_ATT = "total";
    private static final String ACTION_VALID = "valid";
    private static final String ACTION_CANCEL = "cancel";
    private static final String MESSAGE_SUCESS_VALIDED= "La commande à bien été enregistré";
    private static final String MESSAGE_SUCESS_CANCELED= "La commande à bien été annulé";


    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String articleID = request.getParameter(ADD_ARTICLE_ATT);
		session.removeAttribute("message");

		request.setAttribute("page","noorder");

		String action = "";
		if(request.getPathInfo() != null){
			action = request.getPathInfo().replace("/", "");
		}
		
		//if check if user call an action
		if(action.equals(ACTION_VALID)){
			if (session.getAttribute(SESSION_ORDER_ATT) != null) {
				@SuppressWarnings("unused")
				Commande order = (Commande) session.getAttribute(SESSION_ORDER_ATT);
				log("order VALIDED | cause : user disconnected");
				session.removeAttribute(SESSION_ORDER_ATT);
				session.removeAttribute(SESSION_ARTICLES_ATT);
				session.removeAttribute(SESSION_PRICE_ATT);
			}
			session.setAttribute("message", MESSAGE_SUCESS_VALIDED);
			getServletContext().getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response); 
			return;
		}
		else if(action.equals(ACTION_CANCEL)){
			if (session.getAttribute(SESSION_ORDER_ATT) != null) {
				Commande order = (Commande) session.getAttribute(SESSION_ORDER_ATT);
				OrderService.removeOrder(order);
				log("order CANCELED | cause : user choice");
				session.removeAttribute(SESSION_ORDER_ATT);
				session.removeAttribute(SESSION_ARTICLES_ATT);
				session.removeAttribute(SESSION_PRICE_ATT);
			}
			session.setAttribute("message", MESSAGE_SUCESS_CANCELED);
			getServletContext().getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response); 
			return;
		}
		//if article param not exist return order list
		else if (articleID == null) {
			request.setAttribute("page","order");
			if (session.getAttribute(SESSION_ARTICLES_ATT) == null) {
				request.setAttribute("page","noorder");
			}
			getServletContext().getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response); 
			return;
		}
		//if isset a article id
		else{
			request.setAttribute("page","order");
			ArticlePersistence serviceArt = PersistenceServiceProvider.getService(ArticlePersistence.class);
			Article article = (Article) serviceArt.load(Integer.valueOf(articleID));
			if (article==null) {
				throw new EntityNotFoundException("Article introuvable");
			}
			//create a commande
			Commande commande = new Commande();

			if (session.getAttribute(SESSION_ORDER_ATT) == null) {
				CommandePersistence serviceCmd = PersistenceServiceProvider.getService(CommandePersistence.class);
				commande.setAdherent((Adherent) session.getAttribute("adherent"));
				commande.setDateCmd(new Date());
				//create new commande
				commande = serviceCmd.insert(commande);
				session.setAttribute(SESSION_ORDER_ATT, commande);
			}
			else {
				commande = (Commande) session.getAttribute(SESSION_ORDER_ATT);
			}
			
			CommandeArticle ca = OrderService.addArticle(commande,article);
			
			System.out.println(OrderService.getOrderTotalPrice(commande));
			session.setAttribute(SESSION_ARTICLES_ATT, OrderService.listArticlesByOrder(commande));
			session.setAttribute(SESSION_PRICE_ATT, OrderService.getOrderTotalPrice(commande));
			getServletContext().getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response); 
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

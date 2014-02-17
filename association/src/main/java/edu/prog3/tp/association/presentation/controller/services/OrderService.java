/**
 * 
 */
package edu.prog3.tp.association.presentation.controller.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.prog3.tp.association.bean.Adherent;
import edu.prog3.tp.association.bean.Article;
import edu.prog3.tp.association.bean.Commande;
import edu.prog3.tp.association.bean.CommandeArticle;
import edu.prog3.tp.association.persistence.PersistenceServiceProvider;
import edu.prog3.tp.association.persistence.services.ArticlePersistence;
import edu.prog3.tp.association.persistence.services.CommandeArticlePersistence;
import edu.prog3.tp.association.persistence.services.CommandePersistence;

/**
 * @author Laigle Mael
 *
 */
public class OrderService {
	//private static CommandePersistence commandeService = PersistenceServiceProvider.getService(CommandePersistence.class);
	private static CommandeArticlePersistence cmdArtService = PersistenceServiceProvider.getService(CommandeArticlePersistence.class);
	private static ArticlePersistence artService = PersistenceServiceProvider.getService(ArticlePersistence.class);
	private static CommandePersistence cmdService = PersistenceServiceProvider.getService(CommandePersistence.class);

		
		/**
		 * Return list of article finded by order
		 * @param ca
		 * @param c
		 * @return
		 */
		public static List<CommandeArticle> listArticlesByOrder(Commande c){
			 return cmdArtService.getAllArticleByCommande(c);
		}
		
		/**
		 * Return list of article finded by order
		 * @param ca
		 * @param c
		 * @return
		 */
		public static List<CommandeArticle> listArticlesByAdherent(Adherent a){
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", a.getId());
			return cmdArtService.loadByNamedQuery("CommandeArticle.getAllArticleByAdherent", param);
		}
		
		
		/**
		 * Return order total price
		 * @param c
		 * @return
		 */
		public static double getOrderTotalPrice(Commande c){
			double sum = 0.0;
			for (CommandeArticle order : listArticlesByOrder(c)) {
				sum += order.getArticle().getPrix()*order.getQuantite();
			}
			return sum;
		}
		
		/**
		 * Add article to an order
		 * @param c
		 * @param a
		 * @param ca
		 * @return
		 */
		public static CommandeArticle addArticle(Commande c, Article a) {
		  CommandeArticle cmd = cmdArtService.load(c.getId(), a.getCode());
		    if (cmd == null) {
		    	cmd = new CommandeArticle();
		    	cmd.setCommandeId(c.getId());
		    	cmd.setArticleCode(a.getCode());
		    	cmd.setArticle(a);
		    	cmd.setCommande(c);
		    	cmd.setQuantite(1);
		    	a.setStock(a.getStock()-1);
		    	artService.save(a);
				return cmdArtService.insert(cmd);
			}
		    a.setStock(a.getStock()-1);
	    	artService.save(a);
		    cmd.setQuantite(cmd.getQuantite()+1);
		    return cmdArtService.save(cmd);
		}
		
		/**
		 * Remove an order 
		 * @param commande
		 * @return
		 */
		public static void removeOrder(Commande commande){
			for (CommandeArticle orderItem : listArticlesByOrder(commande)) {
				orderItem.getArticle().setStock(orderItem.getArticle().getStock()+orderItem.getQuantite());
				artService.save(orderItem.getArticle());
				cmdArtService.delete(orderItem);
			}
			cmdService.delete(commande);
		}

	}

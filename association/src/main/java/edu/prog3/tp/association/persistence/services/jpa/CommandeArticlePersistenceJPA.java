/*
 * Created on 16 f�vr. 2014 ( Time 14:24:48 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */

package edu.prog3.tp.association.persistence.services.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import edu.prog3.tp.association.bean.Commande;
import edu.prog3.tp.association.bean.CommandeArticle ;
import edu.prog3.tp.association.bean.CommandeArticleKey ;
import edu.prog3.tp.association.persistence.commons.jpa.GenericJpaService;
import edu.prog3.tp.association.persistence.commons.jpa.JpaOperation;
import edu.prog3.tp.association.persistence.services.CommandeArticlePersistence;

/**
 * JPA implementation for basic persistence operations ( entity "CommandeArticle" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class CommandeArticlePersistenceJPA extends GenericJpaService<CommandeArticle, CommandeArticleKey> implements CommandeArticlePersistence {

	/**
	 * Constructor
	 */
	public CommandeArticlePersistenceJPA() {
		super(CommandeArticle.class);
	}

	public CommandeArticle load( Integer commandeId, Integer articleCode ) {
		// Build the composite key
		CommandeArticleKey key = new CommandeArticleKey( commandeId, articleCode );
		return super.load( key );
	}

	public boolean delete( Integer commandeId, Integer articleCode ) {
		// Build the composite key
		CommandeArticleKey key = new CommandeArticleKey( commandeId, articleCode );
		return super.delete( key );
	}

	public boolean delete(CommandeArticle entity) {
		if ( entity != null ) {
			// Build the composite key
			CommandeArticleKey key = new CommandeArticleKey( entity.getCommandeId(), entity.getArticleCode() );
			return super.delete( key );
		}
		return false ;
	}

	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("CommandeArticle.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}
	
	@SuppressWarnings("unchecked")
	public List<CommandeArticle> getAllArticleByCommande(final Commande commande){
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("CommandeArticle.getAllArticleByCommande");
				query.setParameter("id", commande.getId());
				return query.getResultList() ;
			}
		} ;
		// JPA operation execution 
		return (List<CommandeArticle>) execute(operation);
	}

}

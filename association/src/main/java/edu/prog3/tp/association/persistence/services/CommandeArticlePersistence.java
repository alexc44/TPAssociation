/*
 * Created on 16 f�vr. 2014 ( Time 14:24:48 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package edu.prog3.tp.association.persistence.services;

import java.util.List;
import java.util.Map;

import edu.prog3.tp.association.bean.Commande;
import edu.prog3.tp.association.bean.CommandeArticle ;

/**
 * Basic persistence operations for entity "CommandeArticle"
 * 
 * This Bean has a composite Primary Key : CommandeArticleKey
 *
 * @author Telosys Tools Generator
 *
 */
public interface CommandeArticlePersistence {

	/**
	 * Deletes the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param commandearticle
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(CommandeArticle commandearticle) ;

	/**
	 * Deletes the entity by its Primary Key <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param commandeId
	 * @param articleCode
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(Integer commandeId, Integer articleCode) ;

	/**
	 * Inserts the given entity and commit <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param commandearticle
	 */
	public CommandeArticle insert(CommandeArticle commandearticle) ;

	/**
	 * Loads the entity for the given Primary Key <br>
	 * @param commandeId
	 * @param articleCode
	 * @return the entity loaded (or null if not found)
	 */
	public CommandeArticle load(Integer commandeId, Integer articleCode) ;

	/**
	 * Loads ALL the entities (use with caution)
	 * @return
	 */
	public List<CommandeArticle> loadAll() ;

	/**
	 * Loads a list of entities using the given "named query" without parameter 
	 * @param queryName
	 * @return
	 */
	public List<CommandeArticle> loadByNamedQuery(String queryName) ;

	/**
	 * Loads a list of entities using the given "named query" with parameters 
	 * @param queryName
	 * @param queryParameters
	 * @return
	 */
	public List<CommandeArticle> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) ;

	/**
	 * Saves (create or update) the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param commandearticle
	 * @return
	 */
	public CommandeArticle save(CommandeArticle commandearticle) ;

	/**
	 * Search the entities matching the given search criteria
	 * @param criteria
	 * @return
	 */
	public List<CommandeArticle> search( Map<String, Object> criteria ) ;

	/**
	 * Count all the occurrences
	 * @return
	 */
	public long countAll();
	
	/**
	 * find all article by order
	 * @param order
	 * @return
	 */
	public List<CommandeArticle> getAllArticleByCommande(Commande order);
	
}

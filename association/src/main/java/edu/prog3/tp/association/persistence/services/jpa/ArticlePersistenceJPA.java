/*
 * Created on 16 f�vr. 2014 ( Time 14:24:48 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */

package edu.prog3.tp.association.persistence.services.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import edu.prog3.tp.association.bean.Article ;
import edu.prog3.tp.association.persistence.commons.jpa.GenericJpaService;
import edu.prog3.tp.association.persistence.commons.jpa.JpaOperation;
import edu.prog3.tp.association.persistence.services.ArticlePersistence;

/**
 * JPA implementation for basic persistence operations ( entity "Article" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class ArticlePersistenceJPA extends GenericJpaService<Article, Integer> implements ArticlePersistence {

	/**
	 * Constructor
	 */
	public ArticlePersistenceJPA() {
		super(Article.class);
	}

	@Override
	public Article load( Integer code ) {
		return super.load( code );
	}

	@Override
	public boolean delete( Integer code ) {
		return super.delete( code );
	}

	public boolean delete(Article entity) {
		if ( entity != null ) {
			return super.delete( entity.getCode() );
		}
		return false ;
	}
	
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("Article.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}
	
	/**
	 * get all article in stock (stock>0)
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Article> getArticleInStock(final int value) {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("Article.getArticleInStock");
				return query.getResultList();
			}
		} ;
		// JPA operation execution 
		return (List<Article>) execute(operation);
	}

}

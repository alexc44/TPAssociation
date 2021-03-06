/*
 * Created on 16 f�vr. 2014 ( Time 14:24:48 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */

package edu.prog3.tp.association.persistence.services.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import edu.prog3.tp.association.bean.Adherent;
import edu.prog3.tp.association.bean.Commande ;
import edu.prog3.tp.association.persistence.commons.jpa.GenericJpaService;
import edu.prog3.tp.association.persistence.commons.jpa.JpaOperation;
import edu.prog3.tp.association.persistence.services.CommandePersistence;

/**
 * JPA implementation for basic persistence operations ( entity "Commande" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class CommandePersistenceJPA extends GenericJpaService<Commande, Integer> implements CommandePersistence {

	/**
	 * Constructor
	 */
	public CommandePersistenceJPA() {
		super(Commande.class);
	}

	@Override
	public Commande load( Integer id ) {
		return super.load( id );
	}

	@Override
	public boolean delete( Integer id ) {
		return super.delete( id );
	}

	public boolean delete(Commande entity) {
		if ( entity != null ) {
			return super.delete( entity.getId() );
		}
		return false ;
	}

	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("Commande.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}
	
	/**
	 * Count all order by Adherent
	 * @param adh
	 * @return
	 */
	public long countByAdherent(final Adherent adh) {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("Commande.countByAdherent");
				query.setParameter("id", adh.getId());
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}
}

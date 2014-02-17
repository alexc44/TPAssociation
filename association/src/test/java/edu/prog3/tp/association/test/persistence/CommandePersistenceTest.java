/*
 * Created on 16 f�vr. 2014 ( Time 14:24:48 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package edu.prog3.tp.association.test.persistence;


import edu.prog3.tp.association.bean.Commande ;
import edu.prog3.tp.association.mock.CommandeMock;
import edu.prog3.tp.association.persistence.PersistenceServiceProvider;
import edu.prog3.tp.association.persistence.services.CommandePersistence;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for Commande persistence service
 * 
 * @author Telosys Tools Generator
 *
 */
public class CommandePersistenceTest 
{
	@Test
	public void test1() {
		
		System.out.println("Test count ..." );
		
		CommandePersistence service = PersistenceServiceProvider.getService(CommandePersistence.class);
		System.out.println("CountAll = " + service.countAll() );
	}
	
	@Test
	public void test2() {
		
		System.out.println("Test Commande persistence : delete + load ..." );
		
		CommandePersistence service = PersistenceServiceProvider.getService(CommandePersistence.class);
		
		CommandeMock mock = new CommandeMock();
		
		// TODO : set primary key values here 
		process( service, mock, 0  );
		// process( service, mock, ... );
	}

	private void process(CommandePersistence service, CommandeMock mock, Integer id ) {
		System.out.println("----- "  );
		System.out.println(" . load : " );
		Commande entity = service.load( id );
		if ( entity != null ) {
			// Found 
			System.out.println("   FOUND : " + entity );
			
			// Save (update) with the same values to avoid database integrity errors  
			System.out.println(" . save : " + entity );
			service.save(entity);
			System.out.println("   saved : " + entity );
		}
		else {
			// Not found 
			System.out.println("   NOT FOUND" );
			// Create a new instance 
			entity = mock.createInstance( id ) ;
			Assert.assertNotNull(entity);

			// This entity references the following entities : 
			// . Adherent
			/* Insert only if references are OK
			// Try to insert the new instance
			System.out.println(" . insert : " + entity );
			service.insert(entity);
			System.out.println("   inserted : " + entity );
			*/

			System.out.println(" . delete : " );
			boolean deleted = service.delete( id );
			System.out.println("   deleted = " + deleted);
		}		
	}
}
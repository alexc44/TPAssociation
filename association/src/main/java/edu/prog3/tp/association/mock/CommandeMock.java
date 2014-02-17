
/*
 * Created on 16 f�vr. 2014 ( Time 14:24:48 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package edu.prog3.tp.association.mock;

import java.util.LinkedList;
import java.util.List;

import edu.prog3.tp.association.bean.Commande ;
import edu.prog3.tp.association.mock.tool.MockValues;

public class CommandeMock {

	private MockValues mockValues = new MockValues();
	
	/**
	 * Creates an instance with random Primary Key
	 * @return
	 */
	public Commande createInstance() {
		// Primary Key values

		return createInstance( mockValues.nextInteger() );
	}
	
	/**
	 * Creates an instance with a specific Primary Key
	 * @param id1
	 * @return
	 */
	public Commande createInstance( Integer id ) {
		Commande entity = new Commande();
		// Init Primary Key fields
		entity.setId( id) ;
		// Init Data fields
		entity.setDateCmd( mockValues.nextDate() ) ; // java.util.Date 
		// Init Link fields (if any)
		// setAdherent( TODO ) ; // Adherent 
		// setListOfCommandeArticle( TODO ) ; // List<CommandeArticle> 
		return entity ;
	}
	
	/**
	 * Creates a list of instances
	 * @param count number of instances to be created
	 * @return
	 */
	public List<Commande> createList(int count) {
		List<Commande> list = new LinkedList<Commande>();		
		for ( int i = 1 ; i <= count ; i++ ) {
			list.add( createInstance() );
		}
		return list;
	}
}

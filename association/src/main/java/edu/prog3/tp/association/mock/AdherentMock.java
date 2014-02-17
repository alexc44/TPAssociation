
/*
 * Created on 16 f�vr. 2014 ( Time 14:24:48 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package edu.prog3.tp.association.mock;

import java.util.LinkedList;
import java.util.List;

import edu.prog3.tp.association.bean.Adherent ;
import edu.prog3.tp.association.mock.tool.MockValues;

public class AdherentMock {

	private MockValues mockValues = new MockValues();
	
	/**
	 * Creates an instance with random Primary Key
	 * @return
	 */
	public Adherent createInstance() {
		// Primary Key values

		return createInstance( mockValues.nextString(8) );
	}
	
	/**
	 * Creates an instance with a specific Primary Key
	 * @param id1
	 * @return
	 */
	public Adherent createInstance( String id ) {
		Adherent entity = new Adherent();
		// Init Primary Key fields
		entity.setId( id) ;
		// Init Data fields
		entity.setMdp( mockValues.nextString(32) ) ; // java.lang.String 
		entity.setNom( mockValues.nextString(50) ) ; // java.lang.String 
		entity.setPrenom( mockValues.nextString(20) ) ; // java.lang.String 
		entity.setAdresse( mockValues.nextString(100) ) ; // java.lang.String 
		entity.setCp( mockValues.nextString(5) ) ; // java.lang.String 
		entity.setVille( mockValues.nextString(100) ) ; // java.lang.String 
		entity.setPays( mockValues.nextString(25) ) ; // java.lang.String 
		// Init Link fields (if any)
		// setListOfCommande( TODO ) ; // List<Commande> 
		return entity ;
	}
	
	/**
	 * Creates a list of instances
	 * @param count number of instances to be created
	 * @return
	 */
	public List<Adherent> createList(int count) {
		List<Adherent> list = new LinkedList<Adherent>();		
		for ( int i = 1 ; i <= count ; i++ ) {
			list.add( createInstance() );
		}
		return list;
	}
}
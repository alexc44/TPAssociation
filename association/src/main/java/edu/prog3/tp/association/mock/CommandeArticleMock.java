
/*
 * Created on 16 f�vr. 2014 ( Time 14:24:48 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package edu.prog3.tp.association.mock;

import java.util.LinkedList;
import java.util.List;

import edu.prog3.tp.association.bean.CommandeArticle ;
import edu.prog3.tp.association.mock.tool.MockValues;

public class CommandeArticleMock {

	private MockValues mockValues = new MockValues();
	
	/**
	 * Creates an instance with random Primary Key
	 * @return
	 */
	public CommandeArticle createInstance() {
		// Primary Key values

		return createInstance( mockValues.nextInteger(), mockValues.nextInteger() );
	}
	
	/**
	 * Creates an instance with a specific Primary Key
	 * @param id1
	 * @return
	 */
	public CommandeArticle createInstance( Integer commandeId, Integer articleCode ) {
		CommandeArticle entity = new CommandeArticle();
		// Init Primary Key fields
		entity.setCommandeId( commandeId) ;
		entity.setArticleCode( articleCode) ;
		// Init Data fields
		entity.setQuantite( mockValues.nextInteger() ) ; // java.lang.Integer 
		// Init Link fields (if any)
		// setCommande( TODO ) ; // Commande 
		// setArticle( TODO ) ; // Article 
		return entity ;
	}
	
	/**
	 * Creates a list of instances
	 * @param count number of instances to be created
	 * @return
	 */
	public List<CommandeArticle> createList(int count) {
		List<CommandeArticle> list = new LinkedList<CommandeArticle>();		
		for ( int i = 1 ; i <= count ; i++ ) {
			list.add( createInstance() );
		}
		return list;
	}
}
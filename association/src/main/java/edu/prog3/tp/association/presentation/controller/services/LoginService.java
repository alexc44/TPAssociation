package edu.prog3.tp.association.presentation.controller.services;

import edu.prog3.tp.association.bean.Adherent;
import edu.prog3.tp.association.persistence.PersistenceServiceProvider;
import edu.prog3.tp.association.persistence.services.AdherentPersistence;



/**
 * @author LAIGLE Mael
 *	Service to handle adherent login
 */
public class LoginService {
	private static AdherentPersistence serviceAdh = PersistenceServiceProvider.getService(AdherentPersistence.class);
	
	/**
	 * Log adherent
	 * @param login
	 * @param password
	 * @return null if adherent not found else retun adherent
	 */
	public static Adherent login(String login, String password) {
		//try to load adherent
	    Adherent adherent = serviceAdh.load(login);
	    //check password
	  
	    if (adherent != null && adherent.getMdp().equals(password)) {
			return adherent;
		}
	    else return null;
	}
	
}

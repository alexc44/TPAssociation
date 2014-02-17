package edu.prog3.tp.association.presentation.controller.servlets.validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface FormValidator {
	
	/**
	 * Login form validator method
	 * @param request
	 * @return true if ok
	 */
	boolean isValid(HttpServletRequest request, HttpSession session);
}

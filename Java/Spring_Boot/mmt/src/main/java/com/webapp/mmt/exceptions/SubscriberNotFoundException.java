package com.webapp.mmt.exceptions;

public class SubscriberNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SubscriberNotFoundException(String message) {
		super(message);
	}
}

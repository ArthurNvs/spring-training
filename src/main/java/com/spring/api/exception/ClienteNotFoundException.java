package com.spring.api.exception;

public class ClienteNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3846117627939663870L;
	
	public ClienteNotFoundException(Long  id) {
		super("Cliente não encontrado - id: " + id);
	}

}

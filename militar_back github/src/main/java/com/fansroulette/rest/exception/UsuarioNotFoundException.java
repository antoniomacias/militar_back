package com.fansroulette.rest.exception;

public class UsuarioNotFoundException extends RuntimeException {

	public UsuarioNotFoundException(Integer id) {
	    super("Could not find employee " + id);
	  }

	public UsuarioNotFoundException(String lv_aux) {
	    super("Could not find employee " + lv_aux);
	  }
	}
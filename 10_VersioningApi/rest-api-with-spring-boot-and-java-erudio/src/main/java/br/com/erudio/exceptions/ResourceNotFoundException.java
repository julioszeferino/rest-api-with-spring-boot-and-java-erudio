package br.com.erudio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // codigo de erro retornado pela response
public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialversionUID = 1L;
	
	public ResourceNotFoundException(String excecao) {
		super(excecao);
	}
}

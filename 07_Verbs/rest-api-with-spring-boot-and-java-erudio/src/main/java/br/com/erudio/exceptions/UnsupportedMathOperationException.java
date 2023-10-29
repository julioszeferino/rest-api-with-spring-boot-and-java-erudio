package br.com.erudio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) // codigo de erro retornado pela response
public class UnsupportedMathOperationException extends RuntimeException{
	
	public UnsupportedMathOperationException(String excecao) {
		super(excecao);
	}

	private static final long serialversionUID = 1L;
}

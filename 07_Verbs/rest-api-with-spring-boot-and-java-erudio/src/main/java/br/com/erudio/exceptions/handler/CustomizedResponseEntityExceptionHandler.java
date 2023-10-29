package br.com.erudio.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.erudio.exceptions.ExceptionResponse;
import br.com.erudio.exceptions.UnsupportedMathOperationException;

@ControllerAdvice // permite espalhar o comportamento para todos os controllers
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	// metodo para suportar excecoes genericas direcionando erro 500
	// A excecao Exception.class e a excecao generica do JAVA
	@ExceptionHandler(Exception.class)
	private final ResponseEntity<ExceptionResponse> handleAllExceptions(
		Exception ex, // excecao
		WebRequest request // requisicao que gerou a excecao
	){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(
												new Date(),
												ex.getMessage(),
												request.getDescription(false)
											);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	// metodo para suportar nossa excecao especifica
	@ExceptionHandler(UnsupportedMathOperationException.class)
	private final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(
		Exception ex, // excecao
		WebRequest request // requisicao que gerou a excecao
	){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(
												new Date(),
												ex.getMessage(),
												request.getDescription(false)
											);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}

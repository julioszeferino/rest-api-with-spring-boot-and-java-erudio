package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;

@RestController 
public class MathController {
	
	private final AtomicLong counter = new AtomicLong();
	private SimpleMath math = new SimpleMath();
	
	
	@RequestMapping(
		value="/sum/{numberOne}/{numberTwo}", // rota com pathParams
		method=RequestMethod.GET // metodo que requisita a rota
	)
	public Double sum(
		// @PathVariable: permite recuperar os pathParams
		@PathVariable(value="numberOne") String numberOne,
		@PathVariable(value="numberTwo") String numberTwo
	) throws Exception {
		// validando as info que o user passou
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	
	@RequestMapping(
		value="/sub/{numberOne}/{numberTwo}", // rota com pathParams
		method=RequestMethod.GET // metodo que requisita a rota
	)
	public Double sub(
		// @PathVariable: permite recuperar os pathParams
		@PathVariable(value="numberOne") String numberOne,
		@PathVariable(value="numberTwo") String numberTwo
	) throws Exception {
		// validando as info que o user passou
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	
	@RequestMapping(
		value="/mult/{numberOne}/{numberTwo}", // rota com pathParams
		method=RequestMethod.GET // metodo que requisita a rota
	)
	public Double mult(
		// @PathVariable: permite recuperar os pathParams
		@PathVariable(value="numberOne") String numberOne,
		@PathVariable(value="numberTwo") String numberTwo
	) throws Exception {
		// validando as info que o user passou
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	
	@RequestMapping(
		value="/diff/{numberOne}/{numberTwo}", // rota com pathParams
		method=RequestMethod.GET // metodo que requisita a rota
	)
	public Double diff(
		// @PathVariable: permite recuperar os pathParams
		@PathVariable(value="numberOne") String numberOne,
		@PathVariable(value="numberTwo") String numberTwo
	) throws Exception {
		// validando as info que o user passou
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		// verificando se o denominador e diferente de 0
		if(NumberConverter.convertToDouble(numberTwo)==0.00) {
			throw new UnsupportedMathOperationException("Please set a numberTwo different of zero!");
		}
		return math.diff(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	
	@RequestMapping(
		value="/mean/{numberOne}/{numberTwo}", // rota com pathParams
		method=RequestMethod.GET // metodo que requisita a rota
	)
	public Double mean(
		// @PathVariable: permite recuperar os pathParams
		@PathVariable(value="numberOne") String numberOne,
		@PathVariable(value="numberTwo") String numberTwo
	) throws Exception {
		// validando as info que o user passou
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	
	@RequestMapping(
		value="/raiz/{numberOne}", // rota com pathParams
		method=RequestMethod.GET // metodo que requisita a rota
	)
	public Double raiz(
		// @PathVariable: permite recuperar os pathParams
		@PathVariable(value="numberOne") String numberOne
	) throws Exception {
		// validando as info que o user passou
		if(!NumberConverter.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		if(NumberConverter.convertToDouble(numberOne) < 0.00) {
			throw new UnsupportedMathOperationException("This numberic value must be greater than zero!");
		}
		return math.raiz(NumberConverter.convertToDouble(numberOne));
	}
	
	/*
	 * Exemplo:
	 * http://localhost:8080/sum/5.1/25
	 * Returns 30.1
	 * 
	 * http://localhost:8080/sum/5.1/A
	 * Returns
	 * {
		"timestamp": "2023-10-29T14:24:52.512+00:00",
		"message": "Please set a numeric value!",
		"details": "uri=/sum/5.1/A"
		}
	 *
	 */
}

package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;

/*
 * Os controllers no springBoot são responsáveis por receber requisições HTTP dos clientes, 
 * processá-las e retornar as respostas apropriadas
 */

@RestController 
@RequestMapping("/person") // map do controller
public class PersonController {
	
	@Autowired // instancia de modo automatico
	private PersonServices service;
	// private PersonServices service = new PersonServices();
	
	@RequestMapping(
		method=RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE // retorno do metodo sera JSON
	)
	public List<Person> findAll() {
		return service.findAll();
	}

	@RequestMapping(
		value="/{id}", // mesmo que /person/{id}
		method=RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE // retorno do metodo sera JSON
	)
	public Person findById(@PathVariable(value="id") String id) {
		return service.findById(id);
	}
	
	@RequestMapping(
		method=RequestMethod.POST,
		consumes = MediaType.APPLICATION_JSON_VALUE, // vamos consumir um JSON
		produces = MediaType.APPLICATION_JSON_VALUE // retorno do metodo sera JSON
	)
	// Usamos @RequestBody para recuperar parametros do body da requisicao
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}
	
	@RequestMapping(
		method=RequestMethod.PUT,
		consumes = MediaType.APPLICATION_JSON_VALUE, // vamos consumir um JSON
		produces = MediaType.APPLICATION_JSON_VALUE // retorno do metodo sera JSON
	)
	// Usamos @RequestBody para recuperar parametros do body da requisicao
	public Person update(@RequestBody Person person) {
		return service.update(person);
	}
	
	@RequestMapping(
		value="/{id}", // mesmo que /person/{id}
		method=RequestMethod.DELETE
	)
	public void delete(@PathVariable(value="id") String id) {
		service.delete(id);
	}
	
	/*
	 * Exemplo:
	 * http://localhost:8080/person/1
	 * Returns
	   {
		"id": 1,
		"firstName": "Leandro",
		"lastName": "Costa",
		"address": "Uberlandia MG",
		"gender": "Male"
		}
	 */
}

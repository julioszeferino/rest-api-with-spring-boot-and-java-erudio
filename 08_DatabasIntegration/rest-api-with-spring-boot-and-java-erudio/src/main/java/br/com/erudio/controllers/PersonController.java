package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.ResourceNotFoundException;
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
	
	@GetMapping(
		produces = MediaType.APPLICATION_JSON_VALUE // retorno do metodo sera JSON
	)
	public List<Person> findAll() {
		return service.findAll();
	}

	@GetMapping(
		value="/{id}", // mesmo que /person/{id}
		produces = MediaType.APPLICATION_JSON_VALUE // retorno do metodo sera JSON
	)
	public Person findById(@PathVariable(value="id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE, // vamos consumir um JSON
		produces = MediaType.APPLICATION_JSON_VALUE // retorno do metodo sera JSON
	)
	// Usamos @RequestBody para recuperar parametros do body da requisicao
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}
	
	@PutMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE, // vamos consumir um JSON
		produces = MediaType.APPLICATION_JSON_VALUE // retorno do metodo sera JSON
	)
	// Usamos @RequestBody para recuperar parametros do body da requisicao
	public Person update(@RequestBody Person person) {
		return service.update(person);
	}
	
	@DeleteMapping(
		value="/{id}" // mesmo que /person/{id}
	)
	public ResponseEntity<?> delete(@PathVariable(value="id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build(); // retorna status 204
	}
}

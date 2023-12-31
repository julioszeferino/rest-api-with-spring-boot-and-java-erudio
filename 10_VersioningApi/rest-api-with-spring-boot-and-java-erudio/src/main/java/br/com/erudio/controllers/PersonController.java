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

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exceptions.ResourceNotFoundException;

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
	public List<PersonVO> findAll() {
		return service.findAll();
	}

	@GetMapping(
		value="/{id}", // mesmo que /person/{id}
		produces = MediaType.APPLICATION_JSON_VALUE // retorno do metodo sera JSON
	)
	public PersonVO findById(@PathVariable(value="id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE, // vamos consumir um JSON
		produces = MediaType.APPLICATION_JSON_VALUE // retorno do metodo sera JSON
	)
	// Usamos @RequestBody para recuperar parametros do body da requisicao
	public PersonVO create(@RequestBody PersonVO person) {
		return service.create(person);
	}
	
	@PostMapping(
			value="/v2",
			consumes = MediaType.APPLICATION_JSON_VALUE, // vamos consumir um JSON
			produces = MediaType.APPLICATION_JSON_VALUE // retorno do metodo sera JSON
		)
		// Usamos @RequestBody para recuperar parametros do body da requisicao
		public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
			return service.createV2(person);
		}
	
	@PutMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE, // vamos consumir um JSON
		produces = MediaType.APPLICATION_JSON_VALUE // retorno do metodo sera JSON
	)
	// Usamos @RequestBody para recuperar parametros do body da requisicao
	public PersonVO update(@RequestBody PersonVO person) {
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

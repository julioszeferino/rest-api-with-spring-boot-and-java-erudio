package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

/*
 * Os services no SpringBoot vao conter as logicas de negocio.
 */

@Service 
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		logger.info("Finding all people!");
		List<Person> persons = new ArrayList<>();
		// criando um mock com 9 pessoas:
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}
	
	public Person findById(String id) {
		logger.info("Finding one Person");
		Person person = new Person();
		// criando o mock (estrutura temporaria para testarmos o des.):
		person.setId(counter.incrementAndGet());
		person.setFirstName("Leandro");
		person.setLastName("Costa");
		person.setAddress("Uberlandia MG");
		person.setGender("Male");
		// retornando o Mock 
		return person;
	}
	
	public Person create(Person person) {
		logger.info("Creating one Person");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating one Person");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting one Person");
	}
	
	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("personName" + i);
		person.setLastName("personLastName" + i);
		person.setAddress("some address in brazil");
		person.setGender("Male");
		return person;
	}
}

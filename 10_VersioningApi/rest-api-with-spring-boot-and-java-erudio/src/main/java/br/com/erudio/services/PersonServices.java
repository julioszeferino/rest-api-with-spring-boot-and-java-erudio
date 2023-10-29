package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

/*
 * Os services no SpringBoot vao conter as logicas de negocio.
 * Usaremos o dozer para fazer o mapeamento do VO para model
 */

@Service 
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired // instanciar automaticamente
	PersonRepository repository;
	
	@Autowired
	PersonMapper mapperV2;
	
	public List<PersonVO> findAll() {
		logger.info("Finding all people!");
		// retornando convertido para PersonVO
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}
	
	public PersonVO findById(Long id) {
		logger.info("Finding one PersonVO");
		// recuperando a entidade
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!") );
		// convertendo a entidade para VO e retornando
		return DozerMapper.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO create(PersonVO person) {
		logger.info("Creating one PersonVO");
		// convertendo de personVO para a entidade person
		var entity = DozerMapper.parseObject(person, Person.class);
		// salvando a entidade no BD e depois convertendo novamente para VO
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		// retornando o VO
		return vo;
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		logger.info("Creating one PersonVO with V2!");
		// convertendo de personVO para a entidade person
		var entity = mapperV2.convertVoToEntity(person);
		// salvando a entidade no BD e depois convertendo novamente para VO
		var vo = mapperV2.convertEntityToVo(repository.save(entity));
		// retornando o VO
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("Updating one PersonVO");
		// buscando se a pessoa ja existe
		var entity = repository.findById(person.getId())
							.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!") );
		// atualizando os dados
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		// realizando o updade da entidade e convertendo para VO
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		// retornando o VO
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deleting one PersonVO");
		// buscando se a pessoa ja existe
		var entity = repository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!") );
		repository.delete(entity);
	}
}

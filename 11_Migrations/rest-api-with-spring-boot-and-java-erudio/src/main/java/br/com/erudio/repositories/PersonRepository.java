package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erudio.model.Person;

/*
 * Responsavel por conectar nosso model com o BD
 */

@Repository
// JpaRepository<Modelo,Tipo do dado do ID da tabela> 
public interface PersonRepository extends JpaRepository<Person,Long>{}

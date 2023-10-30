package br.com.erudio.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@JsonPropertyOrder({"id","address","last_name","first_name","gender"}) // define a ordem de exibicao
public class PersonVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@JsonProperty("first_name") // nome que vai aparecer no JSON
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;
	private String address;
	private String gender;
	
	public PersonVO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@JsonIgnore // vai ocultar este campo no JSON
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	// Usado para garantir que os objetos se comportem corretamente
	// no metodo equals criado abaixo
	@Override
	public int hashCode() {
		return Objects.hash(address, firstName, gender, id, lastName);
	}
	
	// Metodo Equals usado para comparar duas instancias de objetos da classe Person
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVO other = (PersonVO) obj;
		return Objects.equals(address, other.address) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName);
	}		
}

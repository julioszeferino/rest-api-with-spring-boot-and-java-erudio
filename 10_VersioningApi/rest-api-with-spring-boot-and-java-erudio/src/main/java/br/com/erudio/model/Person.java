package br.com.erudio.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Usado para definir a classe como uma tabela do bd
@Table(name="person") // tabela do banco de dados
public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // sera autoincremental
	private Long id;
	
	// https://jakarta.ee/specifications/platform/9/apidocs/
	@Column(name="first_name", nullable=false, length=80)
	private String firstName;
	
	@Column(name="last_name", nullable=false, length=80)
	private String lastName;
	
	// @Column(name="address")
	@Column(nullable=false, length=100) // o nome da coluna sera igual ao nome da variavel
	private String address;
	
	@Column(nullable=false, length=6)
	private String gender;
	
	public Person() {}

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
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName);
	}		
}

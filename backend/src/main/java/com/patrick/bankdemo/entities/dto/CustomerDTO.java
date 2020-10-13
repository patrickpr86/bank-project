package com.patrick.bankdemo.entities.dto;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.patrick.bankdemo.entities.Customer;

public class CustomerDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty(message = "Required field")
	private String name;

	@NotEmpty(message = "Required field")
	private String lastname;

	@NotEmpty(message = "Required field")
	@Email(message = "Invalid email")
	private String email;

	// @NotEmpty(message = "Required field")
	// @Past
	private Instant birthdate;

	@CPF
	private String cpf;
	
	

	public CustomerDTO() {
	}

	public CustomerDTO(Long id, String name, String lastname, String email, Instant birthdate, String cpf) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.birthdate = birthdate;
		this.cpf = cpf;
		
	}

	public CustomerDTO(Customer entity) {
		id = entity.getId();
		name = entity.getName();
		lastname = entity.getLastname();
		email = entity.getEmail();
		birthdate = entity.getBirthdate();
		cpf = entity.getCpf();
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instant getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Instant birthdate) {
		this.birthdate = birthdate;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	

}

package com.patrick.bankdemo.entities.dto;

import java.io.Serializable;

import com.patrick.bankdemo.entities.Address;

public class AddressDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String zipcode;
	private String street;
	private String district; // bairro
	private String complement; // complemento
	private String city;
	private String state;
	
	public AddressDTO() {
		
	}

	public AddressDTO(Long id, String zipcode, String street, String district, String complement, String city,
			String state) {
		
		this.id = id;
		this.zipcode = zipcode;
		this.street = street;
		this.district = district;
		this.complement = complement;
		this.city = city;
		this.state = state;
	}
	
	public AddressDTO(Address entity) {
		this.id = entity.getId();
		this.zipcode = entity.getZipcode();
		this.street = entity.getStreet();
		this.district = entity.getDistrict();
		this.complement = entity.getComplement();
		this.city = entity.getCity();
		this.state = entity.getState();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	

}

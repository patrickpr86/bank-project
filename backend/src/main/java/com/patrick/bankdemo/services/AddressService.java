package com.patrick.bankdemo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patrick.bankdemo.entities.Address;
import com.patrick.bankdemo.entities.Customer;
import com.patrick.bankdemo.entities.dto.AddressDTO;
import com.patrick.bankdemo.repositories.AddressRepository;
import com.patrick.bankdemo.repositories.CustomerRepository;
import com.patrick.bankdemo.services.exceptions.ResourceNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CustomerRepository customerRespository;

	@Transactional
	public AddressDTO findById(Long id) {
		Optional<Address> obj = addressRepository.findById(id);
		Address entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new AddressDTO(entity);

	}

	@Transactional
	public AddressDTO addressCreate(AddressDTO dto, Long customerId) {	
		
		Customer customer  = customerRespository.getOne(customerId);
		
		
		Address entity = new Address();	
		entity.setCustomer(customer);	
		
		entity.setZipcode(dto.getZipcode());
		entity.setStreet(dto.getStreet());
		entity.setDistrict(dto.getDistrict());
		entity.setComplement(dto.getComplement());
		entity.setCity(dto.getCity());
		entity.setState(dto.getState());
		
		entity = addressRepository.save(entity);
		return new AddressDTO(entity);
	}
	

	

	}



package com.patrick.bankdemo.services;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.patrick.bankdemo.entities.Customer;
import com.patrick.bankdemo.entities.dto.CustomerDTO;
import com.patrick.bankdemo.repositories.CustomerRepository;
import com.patrick.bankdemo.services.exceptions.ResourceNotFoundException;

@Service
public class CustomerService {
	
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private S3service s3service;

	@Transactional
	public CustomerDTO findById(Long id) {
		Optional<Customer> obj = customerRepository.findById(id);
		Customer entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new CustomerDTO(entity);
	}

	@Transactional
	public CustomerDTO customerCreate(CustomerDTO dto) {

		Customer entity = new Customer();
		entity.setName(dto.getName());
		entity.setLastname(dto.getLastname());
		entity.setEmail(dto.getEmail());
		entity.setBirthdate(dto.getBirthdate());
		entity.setCpf(dto.getCpf());
		entity = customerRepository.save(entity);
		return new CustomerDTO(entity);
	}

	public URI uploadPicture(MultipartFile multipartFile) {
		return s3service.uploadFile(multipartFile);
	}

}

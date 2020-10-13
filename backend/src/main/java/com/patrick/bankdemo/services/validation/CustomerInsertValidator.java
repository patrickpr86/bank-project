package com.patrick.bankdemo.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.patrick.bankdemo.entities.Customer;
import com.patrick.bankdemo.entities.dto.CustomerDTO;
import com.patrick.bankdemo.repositories.CustomerRepository;
import com.patrick.bankdemo.resources.exceptions.FieldMessage;



public class CustomerInsertValidator implements ConstraintValidator<CustomerInsert, CustomerDTO>{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void initialize(CustomerInsert ann) {
	}

	@Override
	public boolean isValid(CustomerDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		

		Customer aux = customerRepository.findByEmail(dto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}

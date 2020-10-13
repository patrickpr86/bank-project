package com.patrick.bankdemo.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.patrick.bankdemo.entities.dto.AddressDTO;
import com.patrick.bankdemo.services.AddressService;

@RestController
@RequestMapping(value = "/customers/{customerId}/addresses")
public class AddressResource {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AddressDTO> findById(@PathVariable Long id) {
		AddressDTO dto = addressService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<AddressDTO> addressCreate(@Valid @RequestBody AddressDTO dto, @PathVariable Long customerId) {
		dto = addressService.addressCreate(dto, customerId);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/customers/picture").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);		
	}
	

}

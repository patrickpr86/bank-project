package com.patrick.bankdemo.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.patrick.bankdemo.entities.dto.CustomerDTO;
import com.patrick.bankdemo.services.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<CustomerDTO> findById(@PathVariable Long id) {
		CustomerDTO dto = customerService.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CustomerDTO> customerCreate(@Valid @RequestBody CustomerDTO dto) {
		dto = customerService.customerCreate(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/customers/{customerId}/addresses")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PostMapping(value = "/picture")
	public ResponseEntity<CustomerDTO> uploadPicture(@RequestParam(name = "file") MultipartFile file) {
		URI uri = customerService.uploadPicture(file);
		return ResponseEntity.created(uri).build();
	}

}

package com.patrick.bankdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patrick.bankdemo.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	

	

	

}

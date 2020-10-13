package com.patrick.bankdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class BankdemoApplication  {
	
	

	public static void main(String[] args) {
		SpringApplication.run(BankdemoApplication.class, args);
	}
	
	/*
	 * @Override public void run(String... args) throws Exception {
	 * s3service.uploadFile("/home/patrick/Pictures/pat.jpg"); }
	 */
}

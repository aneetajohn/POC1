package com.oasis.poc1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oasis.poc1.entity.Token;
import com.oasis.poc1.service.POC1Service;


@RestController
public class POC1Controller {
	
	@Autowired
	POC1Service service;
	
	@GetMapping("/OASIS/POC1")
	public String welcomeMessage() {
		return "Hello From Core Web Application, OASIS - POC-1.";		
	}
	
	@GetMapping("/testGetAPI")
	public ResponseEntity<?> testExternalGetRestAPI(@RequestBody String url){
		ResponseEntity<?> responseEntity=service.testExternalGetRestAPIUsingRestTemmplate(url);
		return responseEntity;		
	}
	
	@PostMapping("/getTokenAPI")
	public ResponseEntity<Token>  testTokenAPI(){	
		ResponseEntity<Token> responseEntity=service.testGenerateTokenAPI();		
		return responseEntity;				
	}

}

package com.oasis.poc1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oasis.poc1.entity.SubsetQuery;
import com.oasis.poc1.entity.Token;
import com.oasis.poc1.service.Poc1Service;


@RestController
public class Poc1Controller {
	
	@Autowired
	Poc1Service service;
	
	Logger logger = LoggerFactory.getLogger(Poc1Controller.class);
	
	@GetMapping("/OASIS/POC1")
	public String welcomeMessage() {
		return "Hello From Core Web Application, OASIS - POC-1.";		
	}
	
	@GetMapping("/testGetApi")
	public ResponseEntity<?> testExternalGetRestApi(@RequestBody String url){
		ResponseEntity<?> responseEntity=service.testExternalGetRestAPIUsingRestTemmplate(url);
		return responseEntity;		
	}
	
	@GetMapping("/testTokenApi")
	public ResponseEntity<?> testTokenApi(){	
		ResponseEntity<?> responseEntity = service.testGenerateTokenApi();			
		return responseEntity;				
	}

	@GetMapping("/testWellQuery")
	public ResponseEntity<?> testPetroleumWellApi(){	
		ResponseEntity<?> responseEntity=service.testPetroleumWellSubsetQuery();		
		return responseEntity;				
	}
	
	@GetMapping("/testTileQuery")
	public ResponseEntity<SubsetQuery> testTileDrainageAreaApi(){	
		ResponseEntity<SubsetQuery> responseEntity=service.testTileDrainageAreaSubsetQuery();		
		return responseEntity;				
	}
}

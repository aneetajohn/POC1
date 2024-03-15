package com.oasis.poc1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oasis.poc1.entity.OutputJson;
import com.oasis.poc1.service.CoreWebArcGisService;

@RestController
public class CoreWebArcGisController {
	
	@Autowired
	CoreWebArcGisService service;
	
	@GetMapping("/testCommunication")
	public ResponseEntity<OutputJson[]> testCoreWebArcGisCommunication(){
		ResponseEntity<OutputJson[]> responseEntity=service.testCoreWebArcGisCommunication();
		return responseEntity;	
	}
	
}

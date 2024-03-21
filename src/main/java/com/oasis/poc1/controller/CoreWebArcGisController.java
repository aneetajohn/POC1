package com.oasis.poc1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oasis.poc1.entity.OutputJson;
import com.oasis.poc1.service.CoreWebArcGisService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "POC 1", description = "ArcGIS - Core Web App Communucation")
@RestController
public class CoreWebArcGisController {
	
	@Autowired
	CoreWebArcGisService service;
	
	@GetMapping("/getCoreWebArcGisCommunication")
	public ResponseEntity<OutputJson[]> testCoreWebArcGisCommunication(){
		ResponseEntity<OutputJson[]> responseEntity=service.testCoreWebArcGisCommunication();
		return responseEntity;	
	}
	
}

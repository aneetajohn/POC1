package com.oasis.poc1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oasis.poc1.entity.OutputJson;
import com.oasis.poc1.service.CoreWebArcGisService;

import io.swagger.v3.oas.annotations.tags.Tag;
/**************
 * Class: CoreWebArcGisController 
 * 
 * Purpose: Rest controller class that sends information from Core Web to ArcGIS Enterprise.
 *          Poc1 - BiDirectional Communication - Core Web to ArcGIS Enterprise
 */
@CrossOrigin(origins = "https://oasis-poc2-dynamicui.azurewebsites.net")
@Tag(name = "POC 1", description = "ArcGIS - Core Web App Communucation")
@RestController
public class CoreWebArcGisController {
	
	@Autowired
	CoreWebArcGisService service;
	

	/**************
	 * Method: getCoreWebArcGisCommunication 
	 * Purpose: This method will return updated UI form elements in the response
	 * Input parameters: None
	 * @return OutputJson
	 */
	@GetMapping("/getCoreWebArcGisCommunication")
	public ResponseEntity<OutputJson[]> getCoreWebArcGisCommunication(){
		ResponseEntity<OutputJson[]> responseEntity=service.getCoreWebArcGisCommunication();
		return responseEntity;	
	}
	
}

package com.oasis.poc1.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oasis.poc1.entity.OutputJson;
/**************
 * Class: CoreWebArcGisService 
 * 
 * Purpose: Acts as a service layer that sends information from Core Web to ArcGIS Enterprise.
 *     Poc1 - BiDirectional Communication - Core Web to ArcGIS Enterprise
 */
@Service
public class CoreWebArcGisService {
	
	@Autowired
	ResourceLoader resourceLoader;
	
	Logger logger = LoggerFactory.getLogger(CoreWebArcGisService.class);
	
	/**************
	 * Method: getCoreWebArcGisCommunication 
	 * Purpose: This method will check for the updated data file 
	 *          and read its contents and send it back as response        
	 * Input parameters: None
	 * @return OutputJson[]
	 */
	public ResponseEntity<OutputJson[]> getCoreWebArcGisCommunication(){
		logger.info("CoreWebArcGisService - getCoreWebArcGisCommunication() begins");
		ResponseEntity<OutputJson[]> responseEntity=null;		
		try {
			String home = System.getProperty("user.home");
			String filepath = home+"/Downloads/Output.json";
			File file = new File(filepath);
			String fileContent ="";
			if(file.exists() && file.canRead()) {
				//Reading Output.JSON file in Downloads path if file exists
				 fileContent = new String(Files.readAllBytes(Paths.get(filepath)));				
			}else {
				//Reading Output.JSON file in Resource folder 
				Resource resource = resourceLoader.getResource("classpath:output.json");
				fileContent = new String(resource.getInputStream().readAllBytes());
			}
			if(Objects.nonNull(fileContent)&&!fileContent.isEmpty()) {
				ObjectMapper objectMapper = new ObjectMapper();
				OutputJson[] response = objectMapper.readValue(fileContent, OutputJson[].class);
				logger.info("**** Response : "+ Arrays.toString(response) + "****");
				responseEntity = ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(response);
			}else {
				responseEntity = ResponseEntity.noContent().build();
			}
		} catch (IOException e) {
			logger.error("Error in reading JSON file: "+ e.getMessage());			
		}
		logger.info("CoreWebArcGisService - getCoreWebArcGisCommunication() ends");
		return responseEntity;	
	}
}

package com.oasis.poc1.service;

import java.io.IOException;
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

@Service
public class CoreWebArcGisService {
	
	@Autowired
	ResourceLoader resourceLoader;
	
	Logger logger = LoggerFactory.getLogger(CoreWebArcGisService.class);
	
	public ResponseEntity<OutputJson[]> testCoreWebArcGisCommunication(){
		logger.info("Testing Core Web ArcGis Communication begins");
		ResponseEntity<OutputJson[]> responseEntity=null;		
		try {
			Resource resource = resourceLoader.getResource("classpath:output.json");
			String fileContent = new String(resource.getInputStream().readAllBytes());
			if(Objects.nonNull(fileContent)&&!fileContent.isEmpty()) {
				ObjectMapper objectMapper = new ObjectMapper();
				OutputJson[] response = objectMapper.readValue(fileContent, OutputJson[].class);
				responseEntity = ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(response);
			}else {
				responseEntity = ResponseEntity.noContent().build();
			}
		} catch (IOException e) {
			logger.error("Error in reading JSON file: "+ e.getMessage());			
		}
		logger.info("Testing Core Web ArcGis Communication ends");
		return responseEntity;	
	}
}

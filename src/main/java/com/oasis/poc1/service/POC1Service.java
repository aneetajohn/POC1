package com.oasis.poc1.service;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oasis.poc1.entity.ErrorResponse;
import com.oasis.poc1.entity.TileSubsetQuery;
import com.oasis.poc1.entity.Token;
import com.oasis.poc1.entity.WellSubsetQuery;

@Service
@PropertySource(value="application.yml")
public class Poc1Service {
	
	@Autowired
	RestTemplate restTemplate;
		
	@Value("${PETROLEUM_WELL_SUBSET}")
	String petroleumWellSubset;
	
	@Value("${TILE_DRAINAGE_AREA_SUBSET}")
	String tileDrainageAreaSubset;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	Logger logger = LoggerFactory.getLogger(Poc1Service.class);
	
	String tokenString="";
	
	
	//Testing REST API using Rest Template 
	public ResponseEntity<?> testExternalGetRestAPIUsingRestTemmplate(String url){
		
		logger.info("..Testing ArcGIS Enterprise Rest API: " +url+ " begins..");
		ResponseEntity<?> responseEntity =null;
		Object response=restTemplate.getForObject(url, Object.class);		
		if(Objects.nonNull(response)) {
			logger.info("..Success Response from ArcGIS Enterprise Rest API ..");
			logger.info("Response:" + response);
			responseEntity= ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(response);
		}else {
			logger.info("..ArcGIS Enterprise Rest API Call Failed : Empty Response..");
			responseEntity=ResponseEntity.noContent().build();
		}
		logger.info("..Testing ArcGIS Enterprise Rest API "+url+ " ends..");
		return responseEntity;
	}
	
	//Testing ArcGIS Generate Token  API using Rest Template 
	public ResponseEntity<?> testGenerateTokenApi(){			
		
		String tokenUrl="https://lrcgo.maps.arcgis.com/sharing/generateToken";		                			
		logger.info("..Testing ArcGIS Enterprise Generate Token API: " +tokenUrl+ " begins..");
		
		ResponseEntity<?> responseEntity =null;			
		
		try {			
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);	
			
			MultiValueMap<String,String> requestbody = new LinkedMultiValueMap<String,String>();
			requestbody.add("username", "dev_automation");
			requestbody.add("password", "OASISpoc13");
			requestbody.add("f", "json");
			requestbody.add("referer", "https://www.arcgis.com");
			
			HttpEntity<MultiValueMap<String,String>> httpEntity = new HttpEntity<>(requestbody,header);
			
			ResponseEntity<String> response = restTemplate.exchange(tokenUrl,HttpMethod.POST,httpEntity,String.class);		
			if(Objects.nonNull(response)) {
				//Checking if response has error code
				if(!response.getBody().contains("error")) {
					Token token = objectMapper.readValue(response.getBody(), Token.class) ;										
					tokenString = token.getToken();	
					logger.info("..Token received successfully from ArcGIS Enterprise Generate Token API .."+token);
					responseEntity= ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(token);				
				}else {
					ErrorResponse errorResponse = objectMapper.readValue(response.getBody(), ErrorResponse.class) ;	
					logger.info("Error Response received from ArcGIS Enterprise Generate Token API:" + errorResponse);
					responseEntity= ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(errorResponse);
				}			
			}else {			
				logger.info("Empty Response:" + response.getBody());
				logger.error("..ArcGIS Enterprise Generate Token API Call Failed : Empty Response..");
				responseEntity=ResponseEntity.noContent().build();
			}
		} catch (JsonMappingException e) {			
			logger.error("Error in testTokenApi : " + e.getMessage());
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			logger.error("Error in testTokenApi : " + e.getMessage());
			e.printStackTrace();
		}	
		logger.info("..Testing ArcGIS Enterprise Generate Token API "+tokenUrl+ " ends..");
		return responseEntity;
	}
	
	//Testing ArcGIS Petroleum Well API using Rest Template 
	public ResponseEntity<?> testPetroleumWellSubsetQuery(){
		
		logger.info("..Testing ArcGIS Enterprise Petroleum Well API begins..");
	
		ResponseEntity<?> responseEntity =null;
	
		String petroleumWellUrl=petroleumWellSubset+"/query?token="+tokenString;
		
		HttpHeaders header = new HttpHeaders();
		
		MultiValueMap<String,String> requestbody = new LinkedMultiValueMap<String,String>();		
		requestbody.add("f", "json");
		requestbody.add("layerDefs", "0:1=1");
		
		HttpEntity<MultiValueMap<String,String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(requestbody,header);
			                			
		logger.info("Executing ArcGIS Enterprise Petroleum Well API: " +petroleumWellUrl);
					
		try {		
			ResponseEntity<String> response = restTemplate.exchange(petroleumWellUrl,HttpMethod.POST,httpEntity,String.class);
			if(Objects.nonNull(response)) {
				//Checking if response has error code
				if(!response.getBody().contains("error")) {
					WellSubsetQuery petroleumWell = objectMapper.readValue(response.getBody(), WellSubsetQuery.class);
					logger.info("Success Response received from ArcGIS Petroleum Well API .." + petroleumWell);
					responseEntity= ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(petroleumWell);
				}else {
					ErrorResponse errorResponse = objectMapper.readValue(response.getBody(), ErrorResponse.class) ;	
					logger.info("Error Response received from ArcGIS Petroleum Well API:" + errorResponse);
					responseEntity= ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(errorResponse);
				}				
			}else {
				logger.error("..ArcGIS Enterprise Petroleum Well API Call Failed : Empty Response..");
				logger.info("Empty Response:" + response.getBody());
				responseEntity=ResponseEntity.noContent().build();
			}
		}catch(Exception e) {
			logger.error("Error in testing Petroleum Well Subset Query : " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("..Testing ArcGIS Enterprise Petroleum Well API ends..");			
		return responseEntity;			
	}
	
	//Testing ArcGIS Tile Drainage Area Subset Query using Rest Template 
	public ResponseEntity<?> testTileDrainageAreaSubsetQuery(){
			
		logger.info("..Testing ArcGIS Enterprise Tile Drainage Area Subset API begins..");			
		ResponseEntity<?> responseEntity =null;
		logger.info("Token String: " +  tokenString);
		/*
		if(tokenString.isEmpty()) {
			logger.info("Token String is Empty. Generating Token");
			testGenerateTokenApi();
			logger.info("Token String: " +  tokenString);
		}*/
		
		String tileUrl=tileDrainageAreaSubset+"/query?token="+tokenString;   
				
		HttpHeaders header = new HttpHeaders();
	
		MultiValueMap<String,String> requestbody = new LinkedMultiValueMap<String,String>();		
		requestbody.add("f", "json");
		requestbody.add("layerDefs", "{\"6\": \"YEAR_OF_INSTALLATION = 2021\"}");
		
		HttpEntity<MultiValueMap<String,String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(requestbody,header);
		
		logger.info("Executing ArcGIS Enterprise Tile Drainage Area Subset API: " +tileUrl);
		
		try {  			
			ResponseEntity<String> response = restTemplate.exchange(tileUrl,HttpMethod.POST,httpEntity,String.class);		
			if(Objects.nonNull(response)){
				//Checking if response has error code
				if(!response.getBody().contains("error")) {
					TileSubsetQuery tileDrainageArea = objectMapper.readValue(response.getBody(), TileSubsetQuery.class);
					logger.info("Success Response received from ArcGIS Tile Drainage Area Subset API .." + tileDrainageArea);
					responseEntity= ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(tileDrainageArea);
				}else {
					ErrorResponse errorResponse = objectMapper.readValue(response.getBody(), ErrorResponse.class) ;	
					logger.info("Error Response received from ArcGIS Tile Drainage Area Subset API:" + errorResponse);
					responseEntity= ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(errorResponse);
				}				
			}else {
				logger.error("..ArcGIS Enterprise Tile Drainage Area Subset Call Failed : Empty Response..");
				logger.info("Empty Response:" + response.getBody());
				responseEntity=ResponseEntity.noContent().build();
			}
		}catch(Exception e) {
			logger.error("Error in Tile Drainage Area Subset Query : " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("..Testing ArcGIS Enterprise Tile Drainage Area Subset API ends..");			
		return responseEntity;			
	}
	
}

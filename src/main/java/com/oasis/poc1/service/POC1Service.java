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

/**************
 * Class: Poc1Service 
 * 
 * Purpose: Acts as a service layer to establish communication between ArcGIS Enterprise & Core Web.
 *     Poc1 - BiDirectional Communication - ArcGIS Enterprise to Core Web App
 */
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
	
	/**************
	 * Method: getGenerateTokenApi 
	 * Purpose: This method is used to receive a token as response from ArcGis Enterprise API
	 * Input parameters: None
	 * @return Token as response
	 */
	public ResponseEntity<?> getGenerateTokenApi(){				          			
		logger.info("Poc1Service - getGenerateTokenApi() begins..");
		String tokenUrl="https://lrcgo.maps.arcgis.com/sharing/generateToken";		      
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
					logger.info("*** Token received successfully from ArcGIS Enterprise Generate Token API: "+token);
					responseEntity= ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(token);				
				}else {
					ErrorResponse errorResponse = objectMapper.readValue(response.getBody(), ErrorResponse.class) ;	
					logger.info("*** Error Response received from ArcGIS Enterprise Generate Token API:" + errorResponse);
					responseEntity= ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(errorResponse);
				}			
			}else {						
				logger.error("*** ArcGIS Enterprise Generate Token API Call Failed : Empty Response ***");
				responseEntity=ResponseEntity.noContent().build();
			}
		} catch (JsonMappingException e) {			
			logger.error("JsonMappingException in getGenerateTokenApi() : " + e.getMessage());
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			logger.error("JsonProcessingException in getGenerateTokenApi() : " + e.getMessage());
			e.printStackTrace();
		}	
		logger.info("Poc1Service - getGenerateTokenApi() ends");
		return responseEntity;
	}
	
	/**************
	 * Method: getPetroleumWellSubsetQuery 
	 * Purpose: This method is used to test Petroleum Well Subset API Query of ArcGIS Enterprise
	 * Input parameters: None
	 * @return Petroleum Well Query response: WellSubsetQuery
	 */
	public ResponseEntity<?> getPetroleumWellSubsetQuery(){
		
		logger.info("Poc1Service - getPetroleumWellSubsetQuery() begins");
	
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
					logger.info("*** Success Response received from ArcGIS Petroleum Well API: " + petroleumWell);
					responseEntity= ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(petroleumWell);
				}else {
					ErrorResponse errorResponse = objectMapper.readValue(response.getBody(), ErrorResponse.class) ;	
					logger.error("*** Error Response received from ArcGIS Petroleum Well API:" + errorResponse);
					responseEntity= ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(errorResponse);
				}				
			}else {
				logger.error("*** ArcGIS Enterprise Petroleum Well API Call Failed : Empty Response..");				
				responseEntity=ResponseEntity.noContent().build();
			}
		}catch(Exception e) {
			logger.error("Exception in getPetroleumWellSubsetQuery() : " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Poc1Service - getPetroleumWellSubsetQuery() ends");			
		return responseEntity;			
	}
	
	/**************
	 * Method: getTileDrainageAreaSubsetQuery 
	 * Purpose: This method is used to test Tile Drainage Area Subset API Query of ArcGIS Enterprise
	 * Input parameters: None
	 * @return Tile Query response: TileSubsetQuery
	 */
	
	public ResponseEntity<?> getTileDrainageAreaSubsetQuery(){			
		logger.info("Poc1Service - getTileDrainageAreaSubsetQuery() begins");			
		ResponseEntity<?> responseEntity =null;
		
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
					logger.info("*** Success Response received from ArcGIS Tile Drainage Area Subset API .." + tileDrainageArea);
					responseEntity= ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(tileDrainageArea);
				}else {
					ErrorResponse errorResponse = objectMapper.readValue(response.getBody(), ErrorResponse.class) ;	
					logger.info("*** Error Response received from ArcGIS Tile Drainage Area Subset API:" + errorResponse);
					responseEntity= ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(errorResponse);
				}				
			}else {
				logger.error("*** ArcGIS Enterprise Tile Drainage Area Subset Call Failed : Empty Response..");				
				responseEntity=ResponseEntity.noContent().build();
			}
		}catch(Exception e) {
			logger.error("Exception in Tile Drainage Area Subset Query : " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Poc1Service - getTileDrainageAreaSubsetQuery() ends");			
		return responseEntity;			
	}
	
}

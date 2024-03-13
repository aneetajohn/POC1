package com.oasis.poc1.service;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.oasis.poc1.entity.PetroleumWell;
import com.oasis.poc1.entity.Token;

@Service
public class POC1Service {
	
	@Autowired
	RestTemplate restTemplate;
	
	Logger logger = LoggerFactory.getLogger(POC1Service.class);
	
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
	public ResponseEntity<Token> testGenerateTokenAPI(){			
		
		String tokenUrl="https://lrcgo.maps.arcgis.com/sharing/generateToken";
		                			
		logger.info("..Testing ArcGIS Enterprise Generate Token API: " +tokenUrl+ " begins..");
		
		ResponseEntity<Token> responseEntity =null;			
					
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);	
		
		MultiValueMap<String,String> requestbody = new LinkedMultiValueMap<String,String>();
		requestbody.add("username", "dev_automation");
		requestbody.add("password", "OASISpoc13");
		requestbody.add("f", "json");
		requestbody.add("referer", "https://www.arcgis.com");
		
		HttpEntity<MultiValueMap<String,String>> httpEntity = new HttpEntity<>(requestbody,header);
		
		ResponseEntity<Token> response = restTemplate.exchange(tokenUrl,HttpMethod.POST,httpEntity,Token.class);
		Token token = response.getBody();
		tokenString = token.getToken();		
		if(Objects.nonNull(response)) {
			logger.info("..Token received successfully from ArcGIS Enterprise Generate Token API ..");
			logger.info("Response:" + token);
			responseEntity= ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(token);
		}else {
			logger.error("..ArcGIS Enterprise Generate Token API Call Failed : Empty Token..");
			responseEntity=ResponseEntity.noContent().build();
		}
		logger.info("..Testing ArcGIS Enterprise Generate Token API "+tokenUrl+ " ends..");
		return responseEntity;
	}
	
	//Testing ArcGIS Petroleum Well API using Rest Template 
	public ResponseEntity<PetroleumWell> testPetroleumWellAPI(){
		
		logger.info("..Testing ArcGIS Enterprise Petroleum Well API begins..");
		/*
		//Checking if Token is empty 
		if(Objects.isNull(tokenString)||tokenString.isEmpty()) {
			logger.info("..TOKEN is empty...Fetching token from generateToken API");
			testGenerateTokenAPI();			
		}
		*/	
		String PETROLEUM_WELL_subset="https://services5.arcgis.com/D9dI3nY76wGaru7T/arcgis/rest/services/PETROLEUM_WELL_subset/FeatureServer";
		String tokenUrl=PETROLEUM_WELL_subset+"/query?token="+tokenString+"&f=json&layerDefs=0:1=1";
			                			
		logger.info("..Testing ArcGIS Enterprise Petroleum Well API: " +tokenUrl+ " begins..");
			
		ResponseEntity<PetroleumWell> responseEntity =null;
		
		ResponseEntity<PetroleumWell> response = restTemplate.exchange(tokenUrl,HttpMethod.POST,null,PetroleumWell.class);
		if(Objects.nonNull(response)) {
			logger.info("..Response received successfully from ArcGIS Petroleum Well API ..");
			PetroleumWell petroleumWell = response.getBody();
			logger.info("Petroleum Well API Response:" + petroleumWell);
			responseEntity= ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(petroleumWell);
		}else {
			logger.error("..ArcGIS Enterprise Petroleum Well API Call Failed : Empty Response..");
			responseEntity=ResponseEntity.noContent().build();
		}
		logger.info("..Testing ArcGIS Enterprise Petroleum Well API ends..");			
		return responseEntity;			
	}
	
}

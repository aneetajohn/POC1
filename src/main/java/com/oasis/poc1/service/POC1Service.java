package com.oasis.poc1.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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
import org.springframework.web.client.RestTemplate;

import com.oasis.poc1.entity.Token;



@Service
public class POC1Service {
	
	@Autowired
	RestTemplate restTemplate;
	
	Logger logger = LoggerFactory.getLogger(POC1Service.class);
	
	
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


    //Testing POST API using Rest Template 
	public ResponseEntity<Token> testGenerateTokenAPI(){			
		String tokenUrl="http://lrcgo.maps.arcgis.com/sharing/generateToken";
		
		logger.info("..Testing ArcGIS Enterprise Generate Token API: " +tokenUrl+ " begins..");
		
		ResponseEntity<Token> responseEntity =null;			
					
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);	
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		//key1=value1&key2=value2.
	//	header.setBasicAuth("username=dev_automation&password=OASISpoc12");
		
		Map<String,String> requestbody = new HashMap<>();
		requestbody.put("username", "dev_automation");
		requestbody.put("password", "OASISpoc12");
		requestbody.put("f", "json");
		requestbody.put("referer", "https://www.arcgis.com");
		
		HttpEntity<Map<String,String>> httpEntity = new HttpEntity<Map<String,String>>(requestbody,header);
		responseEntity = restTemplate.exchange(tokenUrl,HttpMethod.POST,httpEntity,Token.class);
		
		Token response = responseEntity.getBody();
		//Object response = restTemplate.postForObject(tokenUrl, httpEntity, Object.class);
		
		//	ResponseEntity<Token> response = restTemplate.postForEntity(tokenUrl, httpEntity, Token.class);
			
		//String response = restTemplate.postForObject(tokenUrl, httpEntity, String.class);
			
		if(Objects.nonNull(response)) {
			logger.info("..Token received successfully from ArcGIS Enterprise Generate Token API ..");
			logger.info("Response:" + response);
			responseEntity= ResponseEntity.status(200).contentType(MediaType.ALL).body(response);
		}else {
			logger.info("..ArcGIS Enterprise Generate Token API Call Failed : Empty Token..");
			responseEntity=ResponseEntity.noContent().build();
		}
		logger.info("..Testing ArcGIS Enterprise Generate Token API "+tokenUrl+ " ends..");
		return responseEntity;
	}
	
}

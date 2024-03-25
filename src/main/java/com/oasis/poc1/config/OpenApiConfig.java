package com.oasis.poc1.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

/**************
 * Class: OpenApiConfig 
 * 
 * Purpose: This class will generate documentation for the Rest APIs 
 * based on the settings provided in @OpenAPIDefinition
 */
@OpenAPIDefinition(
		info = @Info(
					title= "OASIS-POC 1 API",
					description = "Core Web - ArcGIS BiDirectional Communication",				
					summary="GET endpoints to access ArcGIS APIs to establish a communication",
					version="v1"
					/*contact = @Contact(
								name ="Aneeta",
								email ="aneetha.john@ontario.ca"
					)*/	
				),		
				servers = {
						@Server(
								description = "Local Dev",
								url ="http://localhost:9050"
						)
				}
		)
public class OpenApiConfig {

}

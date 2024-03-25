package com.oasis.poc1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**************
 * Class: AppConfig 
 * 
 * Purpose: Configuration class used by JavaConfig as a source of bean definitions 
 * and provides direct access to the beans in JavaConfigApplicationContext  
 */
@Configuration
public class AppConfig {
	
	/**************
	 * Method: getRestTemplate 
	 * Purpose: Bean Creation-This method will return an object of Rest Template 	 
	 * Input parameters: None
	 * @return RestTemplate
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}

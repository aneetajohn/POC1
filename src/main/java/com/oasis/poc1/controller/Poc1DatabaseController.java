package com.oasis.poc1.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oasis.poc1.entity.OasisPoc1;
import com.oasis.poc1.service.Poc1DatabaseService;
/**************
 * Class: Poc1DatabaseController 
 * 
 * Purpose: Rest controller class that has functions to communicates with Oasis_Poc1 Table.   
 *          Oasis_Poc1 : BiDirectional Communication
 * 
 */
@CrossOrigin(origins = "https://oasis-poc2-dynamicui.azurewebsites.net")
@RestController
public class Poc1DatabaseController {
	
	@Autowired
	Poc1DatabaseService service;
	
	/**************
	 * Method: testDatabaseConnection 
	 * Purpose: This method will test the Database Connection status
	 * Input parameters: None
	 * @return Success/Failure string response
	 */
	@GetMapping("/checkDBConnection")
	public String testDatabaseConnection() throws SQLException  {			
		return service.checkDatabaseConnection();
	}
	
	/**************
	 * Method: getAllEntitiesFromDb 
	 * Purpose: This method will return all the entities store in DB
	 * Input parameters: None
	 * @return List of Oasis_Poc1
	 */
	@GetMapping("/getAllPoc1Entities")
	public List<OasisPoc1> getAllEntitiesFromDb(){
		List<OasisPoc1> entityList = service.getAllEntitiesfromDb();
		return entityList;
	}
	
}

package com.oasis.poc1.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oasis.poc1.entity.Oasis_Poc1;
import com.oasis.poc1.service.Poc1DatabaseService;

@RestController
public class Poc1DatabaseController {
	
	@Autowired
	Poc1DatabaseService service;
	
	@GetMapping("/checkDBConnection")
	public String testDatabaseConnection() throws SQLException  {			
		return service.checkDatabaseConnection();
	}
	
	@GetMapping("/getAllEntities")
	public List<Oasis_Poc1> getAllEntitiesFromDb(){
		List<Oasis_Poc1> entityList = service.getAllEntitiesfromDb();
		return entityList;
	}
	
}

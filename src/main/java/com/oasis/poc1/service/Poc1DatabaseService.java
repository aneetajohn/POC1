package com.oasis.poc1.service;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.poc1.entity.OasisPoc1;
import com.oasis.poc1.repository.OasisPoc1Repo;

/**************
 * Class: Poc1DatabaseService 
 * 
 * Purpose: This class will have functions that communicates with Oasis_Poc2 Table.
 *          Oasis_Poc1 : BiDirectional Communication
 */
@Service
public class Poc1DatabaseService {
	
	Logger logger = LoggerFactory.getLogger(Poc1DatabaseService.class);
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	OasisPoc1Repo repository;
	
	/**************
	 * Method: checkDatabaseConnection 
	 * Purpose: This method will test the Database Connection status
	 * Input parameters: None
	 * @return Success/Failure String as response
	 */
	public String checkDatabaseConnection() throws SQLException {	
		logger.info("Poc1DatabaseService - checkDatabaseConnection() begins");
		String response ="";
		if(datasource.getConnection().isValid(1000)) {
			logger.info("Database connection valid = {}"+ datasource.getConnection().isValid(1000));
		    response = "Database is connected successfully";
		    DatabaseMetaData md = datasource.getConnection().getMetaData();
		    ResultSet rs = md.getTables(null, null, "%", null);
		    while (rs.next()) {
		      System.out.println(rs.getString(3));
		    }
		}else {
			response = "Error in connecting database. Please check the connection.";
		}
		logger.info("Poc1DatabaseService - checkDatabaseConnection() ends");
		return response;
	}
	
	/**************
	 * Method: getAllEntitiesFromDb 
	 * Purpose: This method will return all the entity values store in DB
	 * Input parameters: None
	 * @return List <Oasis_Poc1>
	 */	
	public List<OasisPoc1> getAllEntitiesfromDb(){
		logger.info("Poc1DatabaseService - getAllEntitiesfromDb() begins");
		List<OasisPoc1> entityList = new ArrayList<OasisPoc1>();
		entityList=repository.findAll();
		logger.info("Poc1DatabaseService - getAllEntitiesfromDb() ends");
		return entityList;
	}
	
	
}

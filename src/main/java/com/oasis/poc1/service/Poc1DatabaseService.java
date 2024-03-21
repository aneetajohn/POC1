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

import com.oasis.poc1.entity.Oasis_Poc1;
import com.oasis.poc1.repository.OasisPoc1Repo;


@Service
public class Poc1DatabaseService {
	
	Logger logger = LoggerFactory.getLogger(Poc1DatabaseService.class);
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	OasisPoc1Repo repository;
	
	public String checkDatabaseConnection() throws SQLException {	
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
		return response;
	}
	
	public List<Oasis_Poc1> getAllEntitiesfromDb(){
		List<Oasis_Poc1> entityList = new ArrayList<Oasis_Poc1>();
		entityList=repository.findAll();
		return entityList;
	}
	
	
}

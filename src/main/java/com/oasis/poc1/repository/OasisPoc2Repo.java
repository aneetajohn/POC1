package com.oasis.poc1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oasis.poc1.entity.Oasis_Poc2;

/**************
 * Interface: OasisPoc2Repo 
 * 
 * Purpose: This class will act as a repository layer of Oasis_Poc2 table 
 * and contains method to access all DB functions.
 * 
 */
@Repository
public interface OasisPoc2Repo extends JpaRepository<Oasis_Poc2, Integer>{

}

package com.oasis.poc1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oasis.poc1.entity.Oasis_Poc1;


@Repository
public interface OasisPoc1Repo extends JpaRepository<Oasis_Poc1, Integer>{

}

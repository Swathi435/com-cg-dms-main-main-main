package com.cg.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.dms.entities.Farmer;

public interface IFarmerRepository extends JpaRepository<Farmer, Integer> {
	 
}

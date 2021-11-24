package com.cg.dms.repository;

import com.cg.dms.entities.Company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company, Integer> {

}
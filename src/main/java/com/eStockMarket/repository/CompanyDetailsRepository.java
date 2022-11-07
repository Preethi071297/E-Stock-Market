package com.eStockMarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eStockMarket.model.CompanyDetails;

@Repository
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Integer> {
	
	@Query(value= "select name from company_details",nativeQuery=true)
	List<String> getAllCompanyNames();

}

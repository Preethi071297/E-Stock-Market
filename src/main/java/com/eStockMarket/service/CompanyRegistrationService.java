package com.eStockMarket.service;

import java.util.List;
import java.util.Optional;

import com.eStockMarket.model.CompanyDetails;

public interface CompanyRegistrationService {

	public void addCompany(CompanyDetails companyDetails);
	
	public void deleteByCompanyCode(int code);
	
	public List<CompanyDetails> getAllCompanyDetails();
	
	public Optional<CompanyDetails> getCompanyDetailsByCompanyCode(int code);
	
	public List<String> getAllCompanyNames();

}

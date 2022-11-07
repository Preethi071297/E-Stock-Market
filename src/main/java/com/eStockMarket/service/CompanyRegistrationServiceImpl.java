package com.eStockMarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eStockMarket.model.CompanyDetails;
import com.eStockMarket.model.StockDetails;
import com.eStockMarket.repository.CompanyDetailsRepository;
import com.eStockMarket.repository.StockDetailsRepository;

@Service
public class CompanyRegistrationServiceImpl implements CompanyRegistrationService{
	
	@Autowired
	private CompanyDetailsRepository companyDetailsRepository;
	
	@Autowired
	private StockDetailsRepository stockDetailsRepository;

	

	@Override
	public void addCompany(CompanyDetails companyDetails) {
		
		
		companyDetailsRepository.save(companyDetails);
		
	}

	@Override
	public void deleteByCompanyCode(int code) {
		companyDetailsRepository.deleteById(code);
		
		List<StockDetails> list =stockDetailsRepository.findAll().stream().filter(f ->f.getCompCode() == code).collect(Collectors.toList());
		if(list!=null && list.size()>0)
		{
			for(int i=0;i<list.size();i++) {
			 stockDetailsRepository.deleteById(list.get(i).getId());
			}

		}
		
		
		
		
	}

	
	@Override
	public List<CompanyDetails> getAllCompanyDetails() {
		// TODO Auto-generated method stub
		return companyDetailsRepository.findAll();
	}

	@Override
	public Optional<CompanyDetails> getCompanyDetailsByCompanyCode(int code) {
		// TODO Auto-generated method stub
		return companyDetailsRepository.findById(code);
	}

	@Override
	public List<String> getAllCompanyNames() {
		// TODO Auto-generated method stub
		return companyDetailsRepository.getAllCompanyNames();
	}

}

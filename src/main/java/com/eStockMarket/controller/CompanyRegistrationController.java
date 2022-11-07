package com.eStockMarket.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eStockMarket.model.CompanyDetails;
import com.eStockMarket.service.CompanyRegistrationServiceImpl;
import com.eStockMarket.service.StockDetailsServiceImpl;

@RestController
@RequestMapping("/api/v1.0/market/company")
@CrossOrigin
public class CompanyRegistrationController {


	@Autowired
	private CompanyRegistrationServiceImpl companyRegistrationService;
	

	

	@PostMapping(value = "/register")
	public ResponseEntity<Object> addCompany(@RequestBody CompanyDetails companyDetails) {
		try {
		companyRegistrationService.addCompany(companyDetails);
		}catch (Exception ex) {
			return new ResponseEntity<>("Exception:" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping(value = "/delete/{compCode}")
	public ResponseEntity<Object> deleteCompany(@PathVariable("compCode") int compCode) {

		try {
			companyRegistrationService.deleteByCompanyCode(compCode);
		
			
		} catch (Exception ex) {
			return new ResponseEntity<>("Exception:" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(companyRegistrationService.getAllCompanyDetails(), HttpStatus.OK);
	}

	@GetMapping(value = "/getall")
	public ResponseEntity<Object> getAll() {

		try {
			return ResponseEntity.of(Optional.of(companyRegistrationService.getAllCompanyDetails()));
		} catch (Exception ex) {
			return new ResponseEntity<>("Exception:" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * @GetMapping(value = "/getallCompanies") public ResponseEntity<Object>
	 * getAllCompaniesList() {
	 * 
	 * 
	 * List<String> companyList = null;
	 * 
	 * try {
	 * 
	 * companyList = companyRegistrationService.getAllCompanyNames();
	 * 
	 * } catch (Exception ex) { return new ResponseEntity<>("Exception:" +
	 * ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); } return new
	 * ResponseEntity<>(Optional.of(companyList), HttpStatus.OK);
	 * 
	 * }
	 */
	
	@GetMapping(value = "/info/{compCode}")
	public ResponseEntity<Object> getCompanyByCompanyCode(@PathVariable("compCode") int compCode) {

		try {
			companyRegistrationService.getCompanyDetailsByCompanyCode(compCode);
		} catch (Exception ex) {
			return new ResponseEntity<>("Exception:" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(Optional.of( companyRegistrationService.getCompanyDetailsByCompanyCode(compCode)), HttpStatus.OK);
	}

}

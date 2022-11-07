package com.eStockMarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eStockMarket.model.CompanyDetails;
import com.eStockMarket.model.StockDetails;
import com.eStockMarket.service.StockDetailsServiceImpl;

@RestController
@RequestMapping("/api/v1.0/market/stock")
@CrossOrigin

public class StockDetailsController {
	@Autowired
	private StockDetailsServiceImpl stockDetailsService;

	@PostMapping(value = "/add/{compCode}")
	public ResponseEntity<CompanyDetails> addStock(@PathVariable("compCode") int compCode,@RequestBody StockDetails stockDetails) {
		
		stockDetails.setCompCode(compCode);
		stockDetailsService.addStock(stockDetails);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	@GetMapping(value = "/get/{compCode}/{startDate}/{endDate}")
	public ResponseEntity<Object> addStock(@PathVariable("compCode") int compCode,@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate) {
		
		
		System.out.println("startDate" + startDate);
		System.out.println("endDate" + endDate);
List<StockDetails> list = null;
		try {
			if(startDate.equalsIgnoreCase("0") && endDate.equalsIgnoreCase("0")) {
				System.out.println("Entering if");
				list=stockDetailsService.getStockListByCompCode(compCode);

			}else {
				System.out.println("entering else");
				String sDate=startDate.concat(" 00:00:00");
				String eDate=endDate.concat(" 00:00:00");

				list=stockDetailsService.getStockListByCompCodeAndStartDateAndEndDate(compCode,sDate,eDate);
		} 
		}catch (Exception ex) {
			return new ResponseEntity<>("Exception:" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<>(list, HttpStatus.OK);
		}
	
	
	
	
	
	
	
	
	

}

package com.eStockMarket.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eStockMarket.model.StockDetails;
import com.eStockMarket.repository.StockDetailsRepository;

@Service
public class StockDetailsServiceImpl implements StockDetailsService {
	
	@Autowired
	private StockDetailsRepository stockDetailsRepository;

	
	
	@Override
	public void addStock(StockDetails stockDetails) {
		
		stockDetails.setDateTime(LocalDateTime.now());
		stockDetailsRepository.save(stockDetails);
	}

	@Override
	public List<StockDetails> getStockListByCompCodeAndStartDateAndEndDate(int compCode, String startDate,
			String endDate) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime startDateTime = LocalDateTime.parse(startDate, formatter);
		
		LocalDateTime endDateTime = LocalDateTime.parse(endDate, formatter);

	return	stockDetailsRepository.findAllByDateTimeBetween(compCode,startDateTime, endDateTime);
	}

	@Override
	public List<StockDetails> getStockListByCompCode(int compCode) {
		// TODO Auto-generated method stub
		return stockDetailsRepository.findAllByCompCode(compCode);
	}

	@Override
	public void deleteStocksByCompCode(int compCode) {
		// TODO Auto-generated method stub
		 stockDetailsRepository.deleteById(compCode);
		
	}
	
	

}

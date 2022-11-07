package com.eStockMarket.service;

import java.util.List;

import com.eStockMarket.model.StockDetails;

public interface StockDetailsService {
	
	public void addStock(StockDetails stockDetails);
	
	public List<StockDetails> getStockListByCompCodeAndStartDateAndEndDate(int compCode,String startDate, String endDate);
	
	public List<StockDetails> getStockListByCompCode(int compCode);
	
	public void deleteStocksByCompCode(int compCode);
	
}

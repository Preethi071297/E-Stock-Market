package com.eStockMarket.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "stock_details")
public class StockDetails {
	@Transient
	public static final String SEQUENCE_NAME = "stockdetails_sequence";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int compCode;
	private double stockPrice;
	private LocalDateTime dateTime;
	public StockDetails() {
		//super();
		// TODO Auto-generated constructor stub
	}
	

}

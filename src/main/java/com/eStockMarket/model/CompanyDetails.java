package com.eStockMarket.model;

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
@Entity(name = "company_details")
public class CompanyDetails {
	
	@Transient
	public static final String SEQUENCE_NAME = "companydetails_sequence";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int compCode;
	
	private String name;
	
	private String ceo;
	private String turnOver;
	private String website;
	private StockExchange stockExchange;
	public CompanyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

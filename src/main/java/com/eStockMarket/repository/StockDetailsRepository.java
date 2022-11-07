package com.eStockMarket.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eStockMarket.model.StockDetails;

@Repository
public interface StockDetailsRepository extends JpaRepository<StockDetails, Integer>{
	
	@Query(value =  "SELECT * FROM estockdetails.stock_details where comp_code = :compCode and date_time between :startDate and :endDate" ,nativeQuery=true)	
	List<StockDetails> findAllByDateTimeBetween(@Param("compCode") int compCode,@Param("startDate") LocalDateTime startDate,@Param("endDate") LocalDateTime endDate);

	@Query(value =  "SELECT * FROM estockdetails.stock_details where comp_code = :compCode" ,nativeQuery=true)
	List<StockDetails> findAllByCompCode(@Param("compCode") int compCode);
	
	@Modifying
	@Query(value =  "DELETE FROM estockdetails.stock_details where comp_code = :compCode" ,nativeQuery=true)
    int deleteByCompCode(@Param("compCode") int compCode);

    
	
}

package com.webapp.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.webapp.dao.StockDetailsDao;
import com.webapp.entities.StockDetails;


@Component
public class StockDetailsDaoService {

	@Autowired
	private StockDetailsDao stockdao;
	
	
	
	public ArrayList<StockDetails> getstockdetails() {
		
		return stockdao.getstockdetails();
	}
	
	public ArrayList<String> checkajaxcall(String stockname){
		
		return stockdao.checkajaxcall(stockname);
	}
	
	
	
	
	
}

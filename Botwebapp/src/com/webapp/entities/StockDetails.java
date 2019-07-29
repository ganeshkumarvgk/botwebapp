package com.webapp.entities;

import org.springframework.stereotype.Component;

@Component
public class StockDetails {

	private String  stockname;
	private String stockcode;
	private String instrumentcode;
	
	public String getStockname() {
		return stockname;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	public String getStockcode() {
		return stockcode;
	}
	public void setStockcode(String stockcode) {
		this.stockcode = stockcode;
	}
	public String getInstrumentcode() {
		return instrumentcode;
	}
	public void setInstrumentcode(String instrumentcode) {
		this.instrumentcode = instrumentcode;
	}
	
	
}

package com.webapp.entities;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="instrumentcodes")
public class Instrumentcodes {

	
	@Id
	@Column(name = "instrumenttoken")
	private String instrumenttoken;
	@Column(name = "exchangetoken")
	private String exchangetoken;
	@Column(name = "stocksymbol")
	private String stocksymbol;
	@Column(name = "stockname")
	private String stockname;
	@Column(name = "lastprice")
	private String lastprice;
	@Column(name = "expiry")
	private String expiry;
	@Column(name = "strike")
	private String strike;
	@Column(name = "ticksize")
	private String ticksize;
	@Column(name = "lotsize")
	private String lotsize;
	@Column(name = "insrumenttype")
	private String insrumenttype;
	@Column(name = "segment")
	private String segment;
	@Column(name = "exchangename")
	private String exchangename;
	public String getInstrumenttoken() {
		return instrumenttoken;
	}
	public void setInstrumenttoken(String instrumenttoken) {
		this.instrumenttoken = instrumenttoken;
	}
	public String getExchangetoken() {
		return exchangetoken;
	}
	public void setExchangetoken(String exchangetoken) {
		this.exchangetoken = exchangetoken;
	}
	public String getStocksymbol() {
		return stocksymbol;
	}
	public void setStocksymbol(String stocksymbol) {
		this.stocksymbol = stocksymbol;
	}
	public String getStockname() {
		return stockname;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	public String getLastprice() {
		return lastprice;
	}
	public void setLastprice(String lastprice) {
		this.lastprice = lastprice;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public String getStrike() {
		return strike;
	}
	public void setStrike(String strike) {
		this.strike = strike;
	}
	public String getTicksize() {
		return ticksize;
	}
	public void setTicksize(String ticksize) {
		this.ticksize = ticksize;
	}
	public String getLotsize() {
		return lotsize;
	}
	public void setLotsize(String lotsize) {
		this.lotsize = lotsize;
	}
	public String getInsrumenttype() {
		return insrumenttype;
	}
	public void setInsrumenttype(String insrumenttype) {
		this.insrumenttype = insrumenttype;
	}
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
	}
	public String getExchangename() {
		return exchangename;
	}
	public void setExchangename(String exchangename) {
		this.exchangename = exchangename;
	}

}

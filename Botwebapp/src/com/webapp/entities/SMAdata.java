package com.webapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "smadata")
public class SMAdata {

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "stockname")
	private String stockname;

	@Column(name = "smaperiod")
	private String smaperiod;

	@Column(name = "crossoversignal")
	private String crossoversignal;

	public SMAdata() {
	}

	public SMAdata(String stockname, String smaperiod, String crossoversignal) {
		this.stockname = stockname;
		this.smaperiod = smaperiod;
		this.crossoversignal = crossoversignal;
	}

	public SMAdata(long id, String stockname, String smaperiod, String crossoversignal) {
		this.id = id;
		this.stockname = stockname;
		this.smaperiod = smaperiod;
		this.crossoversignal = crossoversignal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStockname() {
		return stockname;
	}

	public void setStockname(String stockname) {
		this.stockname = stockname;
	}

	public String getSmaperiod() {
		return smaperiod;
	}

	public void setSmaperiod(String smaperiod) {
		this.smaperiod = smaperiod;
	}

	public String getCrossoversignal() {
		return crossoversignal;
	}

	public void setCrossoversignal(String crossoversignal) {
		this.crossoversignal = crossoversignal;
	}

}

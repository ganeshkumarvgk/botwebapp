package com.webapp.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.Session;

import com.webapp.entities.Instrumentcodes;
import com.webapp.entities.StockDetails;
import com.webapp.util.HibernateUtil;

public class StockDetailsDao {

	private HibernateUtil hutil = new HibernateUtil();

	Session session = hutil.getSession();
	
	private ArrayList<Instrumentcodes> stocklist = new ArrayList<Instrumentcodes>();
	private ArrayList<StockDetails> stocklist2 = new ArrayList<StockDetails>();
	
	public ArrayList<StockDetails> getstockdetails() {
		
		session.beginTransaction();
		
	Query query=session.createQuery("from Instrumentcodes where segment ='NSE' and stocksymbol !='' and stockname !=''");
	
	stocklist = (ArrayList<Instrumentcodes>) query.getResultList();
	
		System.out.println("stocklist size"+stocklist.size());
	
	for(Instrumentcodes obj:stocklist) {
		StockDetails stockdetails = new StockDetails();
		
		stockdetails.setStockcode(obj.getStocksymbol());
		stockdetails.setStockname(obj.getStockname());
		stockdetails.setInstrumentcode(obj.getInstrumenttoken());
		
		stocklist2.add(stockdetails);
		
		
	}
	System.out.println("stocklist2 size"+stocklist2.size());
	return stocklist2;	
	}
	
}

package com.webapp.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.entities.Instrumentcodes;
import com.webapp.entities.StockDetails;
import com.webapp.util.DaoUtil;
import com.webapp.util.HibernateUtil;


@Component
public class StockDetailsDao{

//	private HibernateUtil hutil = new HibernateUtil();
//
//	Session session = hutil.getSession();
	
	@Autowired
	private SessionFactory sessionFactory;

	//Session session = getSession();
	
//	Session session = sessionFactory.getCurrentSession();
	
	private ArrayList<Instrumentcodes> stocklist = new ArrayList<Instrumentcodes>();
	private ArrayList<StockDetails> stocklist2 = new ArrayList<StockDetails>();
	
	private ArrayList<String>ajaxlist =  new ArrayList<String>();
	
	
	@Transactional
	public ArrayList<StockDetails> getstockdetails() {
		Session session = sessionFactory.getCurrentSession();
//		session.beginTransaction();
		//session.beginTransaction();
		
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
	
	@Transactional
	public ArrayList<String> checkajaxcall(String stockname){
		Session session = sessionFactory.getCurrentSession();
		//session.beginTransaction();
		
		Query query = session.createQuery("select insrumenttype from Instrumentcodes where stockname='"+stockname+"'");
		
		ajaxlist = (ArrayList<String>) query.getResultList();
		
		return ajaxlist;
	}
	
	
}

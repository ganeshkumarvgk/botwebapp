package com.webapp.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.entities.SMAdata;
import com.webapp.util.HibernateUtil;

public class TableDao {
	
	private HibernateUtil hutil = new HibernateUtil();

	Session session = hutil.getSession();

	public void insert() {

		try {
			SMAdata data = new SMAdata("INFY", "8and20", "SELL");

			session.beginTransaction();

			session.save(data);

			session.getTransaction().commit();

		}

		finally {

			hutil.closeSessionFactory();
		}

	}

	public List<SMAdata> getRecords(int start, int total) {

		session.beginTransaction();
		List<SMAdata> list = new ArrayList<SMAdata>();

		ArrayList<SMAdata> smalist = new ArrayList<SMAdata>();
		Query query = session.createQuery("from SMAdata");
		query.setFirstResult(start-1);
		query.setMaxResults(total);

		// query.setParameter("start", start);

		// query.setParameter("total", total);

		list = query.getResultList();

		for (SMAdata object : list) {

			SMAdata data = new SMAdata();

			data.setId(object.getId());

			data.setStockname(object.getStockname());

			data.setSmaperiod(object.getSmaperiod());

			data.setCrossoversignal(object.getCrossoversignal());

			smalist.add(data);

		}
		
		//hutil.closeSessionFactory();
		
		return smalist;

	}
}

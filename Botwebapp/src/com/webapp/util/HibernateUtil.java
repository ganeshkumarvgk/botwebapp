package com.webapp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webapp.entities.Instrumentcodes;
import com.webapp.entities.SMAdata;

public class HibernateUtil {
	
	
	
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
			
			addAnnotatedClass(Instrumentcodes.class).buildSessionFactory();
	public HibernateUtil() {
		
		
	}

	public  Session getSession() {


		Session session = factory.getCurrentSession();
		
		return session;

	}
	
	public void closeSessionFactory() {
		
		factory.close();
	}

}

package com.webapp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class DaoUtil {

	@Autowired
	private SessionFactory factory;
	
	protected Session getSession() {
		
		return factory.getCurrentSession();
	}
	

	public void persist(Object entity) {
		
		getSession().persist(entity);
	}
	
	
	public void delete(Object entity) {
		
		getSession().delete(entity);
	}
	
	
}

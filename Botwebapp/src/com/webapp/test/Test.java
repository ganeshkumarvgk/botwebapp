package com.webapp.test;

import com.webapp.dao.TableDao;

public class Test {

	public static void main(String[] args) {
		
		
		TableDao table = new TableDao();
		
		for(int i =0; i<50;i++)
		
		table.insert();
		
		
	}
	
}

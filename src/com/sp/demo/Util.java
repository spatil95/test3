package com.sp.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {

	static SessionFactory sf;
	Session ss;
	
	public static SessionFactory util()
	{
		Configuration cf=new Configuration();
		cf.configure("hibernate.cfg.xml");
		sf=cf.buildSessionFactory();
		return sf;
	}
}

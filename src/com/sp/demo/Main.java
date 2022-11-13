package com.sp.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main 
{
    public static void main(String[] args) {
		/*
		 * Student s= new Student();
		 * 
		 * SessionFactory sf=Util.util(); Session session=sf.openSession();
		 * 
		 * Query
		 * q=session.createQuery("select s.name,s.id from Student s where s.name =?2 ");
		 * q.setString(2, "sagar"); List list=q.list();
		 * 
		 * Iterator it=list.iterator();
		 * 
		 * while(it.hasNext()) { Object obj[]=(Object[])it.next();
		 * System.out.println(obj[0]+""+obj[1]); }
		 */
    	
    	//session creatd
    	SessionFactory sf= Util.util();
    	Session session= sf.openSession();
    	
		/*
		 * //called get method Student s = session.get(Student.class, 5);
		 * System.out.println("********after calling get method**********");
		 * System.out.println(s.toString());
		 * 
		 * //called get method Student s1 = session.get(Student.class, 6);
		 * System.out.println(s1.toString());
		 * 
		 * Student s2 = session.load(Student.class, 60);
		 * System.out.println("********after calling load method**********");
		 * System.out.println(s2.getName());
		 */
    	Session session3=null;
    	try {
    	System.out.println("\n********++++++++++dirty Checking+++++++++++++**********");
    	session3= sf.openSession();
    	Student s3 = session3.get(Student.class, 9);
    	System.out.println(s3.toString());
    	
    	session3.beginTransaction();
    	s3.setAddress("Thane3");
    	session3.update(s3);
    	//session3.getTransaction().commit();
    	}
    	finally {
    		session3.close();
		}
	}
}

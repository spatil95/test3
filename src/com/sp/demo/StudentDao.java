package com.sp.demo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDao {
	
	public void add(Student student)
	{
		SessionFactory sf=Util.util();
		Session ss= sf.openSession();
		Transaction transaction=ss.beginTransaction();
		
		System.out.println(ss.save(student));
		transaction.commit();
		System.out.println(student.toString());
		
		
	}
	
	public Student list(int id)
	{
		SessionFactory ss=Util.util();
		Session session=ss.openSession();
		Object obj=session.get(Student.class, new Integer(id));
		Student data=(Student)obj;
		return data;
	}
	
	public List<Student> allList()
	{
		SessionFactory ss=Util.util();
		Session session=ss.openSession();
		 Query query = session.getNamedQuery("getAllStudentData");
		
		  List students = query.list();
		return students;
	}
	
	public void update(Student student)
	{
		SessionFactory ss=Util.util();
		Session session=ss.openSession();
		Transaction tr=session.beginTransaction();
		session.update(student);
		tr.commit();
		
	}

}

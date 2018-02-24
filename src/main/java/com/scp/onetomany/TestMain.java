package com.scp.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student1 student1=new Student1("sauru",100);
		Student1 student2=new Student1("megha",200);
		Student1 student3=new Student1("niku",300);
		
		
		Address1 address=new Address1(123,"pune");
		
		
		//Unidirectional and Bidirectional TYPE:Join Column
		
		List<Student1> allStudents = new ArrayList<Student1>();
		
		   student1.setAddress(address);
		   student2.setAddress(address);
		   student3.setAddress(address);
		
		   allStudents.add(student1);
	        allStudents.add(student2);
	        allStudents.add(student3);
	 
	        address.setStudents(allStudents);
		
		
		Configuration cf=new Configuration();
		SessionFactory  sf=cf.configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		
		
		session.persist(address);
		
		List<Student1> students = (List<Student1>) session.createQuery(
                "from Student1 ").list();
        for (Student1 s : students) {
            System.out.println("Student Details : " + s);
            System.out.println("Student University Details: "
                    + s.getAddress());
        }
		
		
		/*
		 * 
		 * one-to-many  unidirectional
		 
		session.save(address);
		session.persist(student1);
		session.persist(student2);
		session.persist(student3);
		
		*/
		
		
		
		 
		
		//session.flush();
		tr.commit();
		
		session.close();
		

	}

}

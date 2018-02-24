package com.scp.onetooneunidirectional;

import java.util.List;

import org.hibernate.Session;
 

 
public class MapMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Student student1 = new Student("sauru");
		Student student2 = new Student("megha");
		Student student3 = new Student("niki");
		
		Address address1 = new Address(10,"USA");
		Address address2 = new Address(11,"UK");
		Address address3 = new Address(12,"NY");


		Session session = Utility.getSessionFactory().openSession();
		session.beginTransaction();

		
		 /** one to one unidirectional
		 * 
		 **/ 
		session.save(address1);
		session.save(address2);
		session.save(address3);
		
		
		student1.setAd(address1);
		session.save(student1);
		
		student2.setAd(address2);
		session.save(student2);
		
		student3.setAd(address3);
		session.save(student3);

		
		
		
		/*
		// one to one Bidirectional
		student.setAd(address);
        address.setStudent(student);
        session.persist(student);

        */
       
      
       
        
		session.getTransaction().commit();
		session.close();  

	}  
}
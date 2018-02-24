package com.scp.onetoonebidirect;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BidirectMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Employee e1=new Employee(10,"sauru", 2000);
		Employee e2=new Employee(20,"niki" ,3000);
		Employee e3=new Employee(30," megha" ,4000);
		
		Address ad1=new Address(123,"pune");
		Address ad2=new Address(345,"mumbai");
		Address ad3=new Address(678,"goa");
		
		
		
		Configuration cfg=new Configuration();
		SessionFactory sf= cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		
		e1.setAdr(ad1);
		e2.setAdr(ad2);
		e3.setAdr(ad3);
		

		
		ad1.setEmp(e1);
		ad2.setEmp(e2);
		ad3.setEmp(e3);
			
	
	session.save(e1);
	session.save(e2);
	session.save(e3);
	
	tr.commit();
	session.close();
		
	
		
		
	}

}

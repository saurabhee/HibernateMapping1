package com.scp.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name="Parent2")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
class Parent2
{
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.TABLE)
	
	private int id;
	@Column
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Parent2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Parent2() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Parent2 [id=" + id + ", name=" + name + "]";
	}
	
}

@Entity
@Table(name="child11")
class Child111 extends  Parent2
{
	@Column
	private int pin;
	@Column
	private String addr;
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Child111(int id, String name, int pin, String addr) {
		super(id, name);
		this.pin = pin;
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Child111 [pin=" + pin + ", addr=" + addr + "]";
	}
	
}

@Entity
@Table(name="child222")
class Child222 extends Parent2
{
	@Column
	private String Country;

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public Child222(int id, String name, String country) {
		super(id, name);
		Country = country;
	}

	@Override
	public String toString() {
		return "Child222 [Country=" + Country + "]";
	}
	
	
}
public class TablePerConcreate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Parent2 p=new Parent2(10,"sauru");
		Child111 c1=new Child111(11, "durga", 123, "pune");
		Child111 c2=new Child111(12, "sauru", 456, "mumbai");
		
		Child222 c3=new Child222(14, "niki", "india");
		Child222 c4=new Child222(15, "megha", "USA");
		
		Configuration cfg=new Configuration();
		SessionFactory sf=cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		session.save(p);
		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(c4);
		
		tr.commit();
		session.close();

	}

}

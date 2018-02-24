package com.scp.inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
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
@Table(name="parent2")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("P")
class Parent
{
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.TABLE)
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

	public Parent(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Parent [id=" + id + ", name=" + name + "]";
	}
	
}
@Entity
@DiscriminatorValue("C1")
class Child1 extends Parent
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
	public Child1(int id, String name, int pin, String addr) {
		super(id, name);
		this.pin = pin;
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return "Child1 [pin=" + pin + ", addr=" + addr + "]";
	}
}

@Entity
@DiscriminatorValue("C2")
class Child2 extends Parent
{
	@Column
	private  String country;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Child2(int id, String name, String country) {
		super(id, name);
		this.country = country;
	}

	

	
	@Override
	public String toString() {
		return "child2 [country=" + country + "]";
	}
	
	
	
}

public class TablePerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Parent p=new Parent(10,"sauru");
		Child1 c1=new Child1(11, "durga", 123, "pune");
		Child1 c2=new Child1(12, "sauru", 456, "mumbai");
		
		Child2 c3=new Child2(14, "niki", "india");
		Child2 c4=new Child2(15, "megha", "USA");
		
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

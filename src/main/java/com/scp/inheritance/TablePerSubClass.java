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
@Table(name="parent11")
@Inheritance(strategy=InheritanceType.JOINED)
class Parent1
{
	@Id
	@Column(name="Identity")
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

	public Parent1(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Parent1() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Parent1 [id=" + id + ", name=" + name + "]";
	}
		
	
}

@Entity
@Table(name="child11")
class Child11 extends Parent1
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
	public Child11(int id, String name, int pin, String addr) {
		super(id, name);
		this.pin = pin;
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Child11 [pin=" + pin + ", addr=" + addr + "]";
	}
	
}

@Entity
@Table(name="child22")
class Child22 extends Parent1
{
	@Column
	private String country;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Child22(int id, String name, String country) {
		super(id, name);
		this.country = country;
	}

	@Override
	public String toString() {
		return "Child22 [country=" + country + "]";
	}
	
	
	
}
public class TablePerSubClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Parent1 p=new Parent1(10,"sauru");
		Child11 c1=new Child11(11, "durga", 123, "pune");
		Child11 c2=new Child11(12, "sauru", 456, "mumbai");
		
		Child22 c3=new Child22(14, "niki", "india");
		Child22 c4=new Child22(15, "megha", "USA");
		
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

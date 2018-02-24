package com.scp.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name="Student10")
class Student10
{
	
	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	
	//1.Join column
	/*@ManyToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="NewId")
	private List<Subject> sub=new ArrayList<Subject>();*/
	
	
	//2.Join table
	/*@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="NewTable",joinColumns=@JoinColumn(name="stud_id"),inverseJoinColumns=@JoinColumn(name="sbu_id"))
	private List<Subject> sub=new ArrayList<Subject>();*/
	
	
	//3.PrimaryKeyJoinColumn
	@ManyToMany(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private List<Subject> sub=new ArrayList<Subject>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Subject> getSub() {
		return sub;
	}
	public void setSub(List<Subject> sub) {
		this.sub = sub;
	}
	public Student10(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		//this.sub=sub;
	}
	public Student10() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", sub=" + sub + "]";
	}

}


@Entity
@Table(name="Subject1")

class Subject
{
	
	@Id
	private int Sub_id;
	private String sbjectName;
	public int getSub_id() {
		return Sub_id;
	}
	public void setSub_id(int sub_id) {
		Sub_id = sub_id;
	}
	public String getSbjectName() {
		return sbjectName;
	}
	public void setSbjectName(String sbjectName) {
		this.sbjectName = sbjectName;
	}
	public Subject(int sub_id, String sbjectName) {
		super();
		Sub_id = sub_id;
		this.sbjectName = sbjectName;
	}
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Subject [Sub_id=" + Sub_id + ", sbjectName=" + sbjectName + "]";
	}
	
}

public class ManyToManyUni {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student10 s1=new Student10(200,"sauru","wandhekar");
		Student10 s2=new Student10(201,"namrata","wandhekar");
		
		
		Subject sb1=new Subject(10, "python");
		Subject sb2=new Subject(20, "java");
		Subject sb3=new Subject(30, "cpp");
		
	   Configuration cfg=new Configuration();
	   SessionFactory sf=cfg.configure().buildSessionFactory();
	   Session session = sf.openSession();
	   Transaction tr = session.beginTransaction();
	   
	   s1.getSub().add(sb1);
	   s1.getSub().add(sb2);
	   s1.getSub().add(sb3);
	   
	   s2.getSub().add(sb1);
	   s2.getSub().add(sb2);
	   
	   session.save(s1);
	   session.save(s2);
	  
	   tr.commit();
	   session.close();
		
		

	}

}

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
@Table(name="student11")
class Student11
{
	@Id
	@GeneratedValue
	private int id;
	private String firstnm;
	private String lastnm;

	//1.join Table
	/*@ManyToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID1")
	List<Subject2>subject=new ArrayList<Subject2>();
	*/
	
	//2.Join column
	/*@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Table1",joinColumns=@JoinColumn(name="s_id"),inverseJoinColumns=@JoinColumn(name="sb_id"))
	List<Subject2>subject=new ArrayList<Subject2>();
	*/
	
	//3.Primary key join column
    @ManyToMany(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	List<Subject2>subject=new ArrayList<Subject2>();
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstnm() {
		return firstnm;
	}

	public void setFirstnm(String firstnm) {
		this.firstnm = firstnm;
	}

	public String getLastnm() {
		return lastnm;
	}

	public void setLastnm(String lastnm) {
		this.lastnm = lastnm;
	}

	public List<Subject2> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject2> subject) {
		this.subject = subject;
	}

	public Student11(int id, String firstnm, String lastnm) {
		super();
		this.id = id;
		this.firstnm = firstnm;
		this.lastnm = lastnm;
	}

	public Student11() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student11 [id=" + id + ", firstnm=" + firstnm + ", lastnm=" + lastnm + ", subject=" + subject + "]";
	}

}

@Entity
@Table(name="subject2")
class Subject2
{
	@Id
	private int subId;
	private String subName;

	
	@ManyToMany(mappedBy="subject")
	List<Student11> stu=new ArrayList<Student11>();

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public List<Student11> getStu() {
		return stu;
	}

	public void setStu(List<Student11> stu) {
		this.stu = stu;
	}

	public Subject2(int subId, String subName) {
		super();
		this.subId = subId;
		this.subName = subName;
	}

	public Subject2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Subject2 [subId=" + subId + ", subName=" + subName + ", stu=" + stu + "]";
	}

}


public class ManyToManyBi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student11 st1=new Student11(100,"sauru","wandhekar");
		Student11 st2=new Student11(101,"akshay","wandhekar");

		Subject2 sb1=new Subject2(10,"java");
		Subject2 sb2=new Subject2(20,"cpp");
		Subject2 sb3=new Subject2(30,"python");

		st1.getSubject().add(sb1);
		st1.getSubject().add(sb2);

		st2.getSubject().add(sb3);
		st2.getSubject().add(sb2);

		Configuration cfg=new Configuration();
		SessionFactory sf=cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		session.save(st1);
		session.save(st2);
		
		tr.commit();
		session.close();






	}

}

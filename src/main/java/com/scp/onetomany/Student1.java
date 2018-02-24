package com.scp.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Student1")
public class Student1 {
	
	@Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="MARKS")
	private int marks;
	
	@ManyToOne(optional = false)
    @JoinColumn(name="Address_ID")
	private Address1 address;

	public Student1(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}

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

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Address1 getAddress() {
		return address;
	}

	public void setAddress(Address1 address) {
		this.address = address;
	}

	public Student1() {
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student1 [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}
	
	

}

package com.scp.onetooneunidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Address11")


public class Address {

	 @Id
     @GeneratedValue
    private long id;

	@Column
	private int pin;
	
	@Column
	private String name;
	
	
	
	
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address(int pin, String name) {
		super();
		this.pin = pin;
		this.name = name;
	}
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/*public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}*/
	@Override
	public String toString() {
		return "Address [pin=" + pin + ", name=" + name + "]";
	}
	public Address() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
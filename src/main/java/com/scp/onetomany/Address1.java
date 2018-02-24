package com.scp.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Address1")
public class Address1 {
	
	@Id
	@GeneratedValue
    @Column(name = "Address_ID")
	
	private int Aid;
	
	@Column(name="PIN")
	private int pin;
	
	@Column(name="CITY")
	private String city;
	
	//For Bidirectional
	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<Student1> students;
	
	
	
	public List<Student1> getStudents() {
		return students;
	}
	public void setStudents(List<Student1> students) {
		this.students = students;
	}
	public int getAid() {
		return Aid;
	}
	public void setAid(int aid) {
		Aid = aid;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address1(int pin, String city) {
		super();
		this.pin = pin;
		this.city = city;
	}
	public Address1() {
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Address1 [Aid=" + Aid + ", pin=" + pin + ", city=" + city + "]";
	}
	
	
	
	

}

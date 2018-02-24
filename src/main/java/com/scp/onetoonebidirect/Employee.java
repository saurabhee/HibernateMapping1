package com.scp.onetoonebidirect;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Employee_Info1")

public class Employee {
	
	
	@Id
    @GeneratedValue
    @Column(name = "EMP_ID")
	private int Id;
	
	
	@Column
	private int empId;
	
	@Column
	private String empName;
	
	@Column
	private int empSalary;
	
	
	/*1) One_One Bidirectional:TYPE:join Column
	 * @OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="NewId")
    */	
	
	
	
	/*2)TYPE:PrimaryKeyJoinColumn
	 * @OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn*/
	
	
	
	//3)One-To-One Bidirectional:TYPE:Join Table
     @OneToOne(mappedBy="emp", cascade = CascadeType.ALL)
	@JoinTable(name="Common",joinColumns=@JoinColumn(name="E_id"),inverseJoinColumns=@JoinColumn(name="A-id"))
	
	
	Address adr;
	
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	

	public Address getAdr() {
		return adr;
	}

	public void setAdr(Address adr) {
		this.adr = adr;
	}

	public Employee(int empId, String empName, int empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}
	
	
	

}

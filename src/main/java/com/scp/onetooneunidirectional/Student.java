package com.scp.onetooneunidirectional;

import javax.persistence.Access;
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
@Table(name = "STUDENT11")



public class Student {
	
	
	@Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
	private int id;
	
	
	@Column
	private String name;
	
	
	//Unidirectional 3 TYPE
     /*1) for Unidirectional -join column
         @JoinColumn(name="HOME_ADDRESS_ID")
         @OneToOne( cascade = CascadeType.ALL)*/



    /*2) Unidirectional=TYPE:join Table
       @OneToOne(cascade=CascadeType.ALL)
       @JoinTable(name="Join_Table",joinColumns=@JoinColumn(name="Stud_id"),inverseJoinColumns=@JoinColumn(name="Add_id"))

*/

	/*3) Unidirectional :TYPE:Primary Key Join column
	   @OneToOne(cascade=CascadeType.ALL)
	   @PrimaryKeyJoinColumn
	 */

	
	@JoinColumn(name="HOME_ADDRESS_ID")
    @OneToOne( cascade = CascadeType.ALL)
    Address ad;
	
	
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
	public Address getAd() {
		return ad;
	}
	public void setAd(Address ad) {
		this.ad = ad;
	}
	
	
	
	public Student( String name) {
		super();
		
		this.name = name;
		
	}
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", ad=" + ad + "]";
	}
	
	
	
	

}

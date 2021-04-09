package com.cg.mts.entities;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="OfficeStaffMember")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="emp_type",discriminatorType=DiscriminatorType.STRING)   
@DiscriminatorValue("EMP")
public class OfficeStaffMember {
	
	@Id
	private int empid;
	private String name;
	private String role;
	
	
	//@OneToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="addressid")
	//private Address address;
	

	
	@OneToOne
	@JoinColumn(name="managerId")
	private Manager mgr;
	
	
	
	public OfficeStaffMember() {
		
	}
	
	
	public OfficeStaffMember(int empid, String name, String role) {
		super();
		this.empid = empid;
		this.name = name;
		this.role = role;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	




	
	@Override
	public String toString() {
		return "OfficeStaffMember [empid=" + empid + ", name=" + name + ", role=" + role +  "]";
	}

	
	
	
}

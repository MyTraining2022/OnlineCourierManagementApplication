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
@Table(name = "OfficeStaffMember")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "emp_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("EMP")
public class OfficeStaffMember {

	@Id
	private int empId;
	private String name;
	private String role;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address address;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "officeId")
	private CourierOfficeOutlet office;

	@OneToOne
	// @JoinColumn(name="managerId")
	private Manager manager;

	public OfficeStaffMember() {

	}

	public OfficeStaffMember(int empId, String name, String role) {
		super();
		this.empId = empId;
		this.name = name;
		this.role = role;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public CourierOfficeOutlet getOffice() {
		return office;
	}

	public void setOffice(CourierOfficeOutlet office) {
		this.office = office;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	/*
	 * public void addEmployee(OfficeStaffMember employee) { employee.setempi(this);
	 * this.getEmployees().add(employee); }
	 */

	/*
	 * public Manager getMgr() { return mgr; }
	 * 
	 * 
	 * public void setMgr(Manager mgr) { this.mgr = mgr; }
	 */

	

}

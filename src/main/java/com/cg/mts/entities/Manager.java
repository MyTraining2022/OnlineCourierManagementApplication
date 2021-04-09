package com.cg.mts.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="manager")
@DiscriminatorValue("MGR")
public class Manager extends OfficeStaffMember {
	
	/*@Id
	private int managerId;
	private String mangName;
	
	
	@OneToMany
	private Set<OfficeStaffMember> staff = new HashSet<>(); */
	
	
	
	@ManyToOne
	@JoinColumn(name="officeId")
	private CourierOfficeOutlet office;
	
	
	public Manager() {
		
	}


	public CourierOfficeOutlet getOffice() {
		return office;
	}


	public void setOffice(CourierOfficeOutlet office) {
		this.office = office;
	}
	
	

	/*public Manager(int managerId, String mangName) {
		super();
		this.managerId = managerId;
		this.mangName = mangName;
	}



	public int getManagerId() {
		return managerId;
	}


	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}


	public String getMangName() {
		return mangName;
	}


	public void setMangName(String mangName) {
		this.mangName = mangName;
	}


	public Set<OfficeStaffMember> getStaff() {
		return staff;
	}


	public void setStaff(Set<OfficeStaffMember> staff) {
		this.staff = staff;
	}


	public CourierOfficeOutlet getOffice() {
		return office;
	}


	public void setOffice(CourierOfficeOutlet office) {
		this.office = office;
	}

	
	public void addStaff(OfficeStaffMember staff) {
		staff.setMgr(this);			//this will avoid nested cascade and also serves the purpose to avoid cyclic references. 
		this.getStaff().add(staff);
	}*/

}

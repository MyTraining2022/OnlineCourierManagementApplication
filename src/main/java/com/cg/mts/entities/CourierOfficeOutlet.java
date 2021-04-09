package com.cg.mts.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CourierOfficeOutlet")
public class CourierOfficeOutlet {
	
	@Id
	private int officeId;
	
	private LocalTime openingTime;
	private LocalTime closingTime;	
	
	@OneToMany(mappedBy="office",cascade=CascadeType.ALL)
	private List<OfficeStaffMember> staffMembers= new ArrayList<>();
    
	
	@OneToOne
	@JoinColumn(name="addressId")
	private Address address;
	
	
	public CourierOfficeOutlet() {
		
	}


	public CourierOfficeOutlet(int officeId, LocalTime openingTime, LocalTime closingTime) {
		super();
		this.officeId = officeId;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
	}


	public int getOfficeId() {
		return officeId;
	}


	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}


	public LocalTime getOpeningTime() {
		return openingTime;
	}


	public void setOpeningTime(LocalTime openingTime) {
		this.openingTime = openingTime;
	}


	public LocalTime getClosingTime() {
		return closingTime;
	}


	public void setClosingTime(LocalTime closingTime) {
		this.closingTime = closingTime;
	}


	public List<OfficeStaffMember> getStaffMembers() {
		return staffMembers;
	}


	public void setStaffMembers(List<OfficeStaffMember> staffMembers) {
		this.staffMembers = staffMembers;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}

	
	

}

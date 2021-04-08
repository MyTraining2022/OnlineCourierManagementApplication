package com.cg.mts.entities;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="office")
public class CourierOfficeOutlet {
	
	@Id
	private int officeid;
	
	private LocalTime openingTime;
	private LocalTime closingTime;	
	
	@OneToMany(mappedBy="office",cascade=CascadeType.ALL)
	private List<OfficeStaffMember> staffmembers;
    
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="houseNo")
	private Address addre;
	
	
	public CourierOfficeOutlet() {
		
	}

	public CourierOfficeOutlet(int officeid, LocalTime openingTime, LocalTime closingTime) {
		super();
		this.officeid = officeid;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
	}

	public int getOfficeid() {
		return officeid;
	}

	public void setOfficeid(int officeid) {
		this.officeid = officeid;
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

	public List<OfficeStaffMember> getStaffmembers() {
		return staffmembers;
	}

	public void setStaffmembers(List<OfficeStaffMember> staffmembers) {
		this.staffmembers = staffmembers;
	}

	public Address getAddress() {
		return addre;
	}

	public void setAddress(Address address) {
		this.addre = address;
	}

	@Override
	public String toString() {
		return "CourierOfficeOutlet [officeid=" + officeid + ", openingTime=" + openingTime + ", closingTime="
				+ closingTime + ", staffmembers=" + staffmembers + ", address=" + addre + "]";
	}
	
	
	
	

}

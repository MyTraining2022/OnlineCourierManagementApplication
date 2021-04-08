package com.cg.mts.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	private int houseNo;
	
    private String street;
	private String city;
	private String state;
	private String country;
	private int zip;
	
	@OneToOne(mappedBy="addr")
	private Customer customer;
	
	@OneToOne(mappedBy="address")
	private OfficeStaffMember officeMem;

	@OneToOne(mappedBy="addre")
	private CourierOfficeOutlet office;
	
	public Address() {
		
	}
	
	
	
	public Address(int houseNo, String street, String city, String state, String country, int zip) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}
	
	
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}


	@Override
	public String toString() {
		return "Address [HouseNo=" + houseNo + ", Street=" + street + ", City=" + city + ", State=" + state
				+ ", Country=" + country + ", Zip=" + zip + "]";
	}

	
	
	
	
	

}

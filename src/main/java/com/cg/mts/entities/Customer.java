package com.cg.mts.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	private int customerid;
	private String firstname;
	private String lastname;
	private int mobileno;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="houseNo")
	private Address addr;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="complaintid")
	private Complaint complaint;
	
	@OneToMany(mappedBy="sender",cascade=CascadeType.ALL)
	private List<Courier>  courierSender;
	
	@OneToMany(mappedBy="receiver",cascade=CascadeType.ALL)
	private List<Courier> courierReceiver;
	
	
	
	
	public Customer() {
		
	}
	
	
	


	public Customer(int customerid, String firstname, String lastname, int mobileno) {
		super();
		this.customerid = customerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
	}


	public int getCustomerid() {
		return customerid;
	}


	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public int getMobileno() {
		return mobileno;
	}


	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}


	public Address getAddr() {
		return addr;
	}


	public void setAddr(Address addr) {
		this.addr = addr;
	}

	
	

	
	public Complaint getComplaint() {
		return complaint;
	}





	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}





	public List<Courier> getCourierSender() {
		return courierSender;
	}





	public void setCourierSender(List<Courier> courierSender) {
		this.courierSender = courierSender;
	}





	public List<Courier> getCourierReceiver() {
		return courierReceiver;
	}





	public void setCourierReceiver(List<Courier> courierReceiver) {
		this.courierReceiver = courierReceiver;
	}





	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", mobileno=" + mobileno + ", Address=" + addr + "]";
	}
	
	
	

}

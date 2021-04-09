package com.cg.mts.entities;

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
@Table(name = "customer")
public class Customer {
	@Id
	private int customerid;
	private int aadharno;
	private String firstname;
	private String lastname;
	private int mobileno;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Complaint> complaint=new ArrayList<>();

	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "houseNo")
	//private Address addr;

	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paymentno")
	private BankAccount acct;

	@OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
	private List<Courier> courierSender = new ArrayList<>();

	@OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
	private List<Courier> courierReceiver = new ArrayList<>();

	public Customer() {
		
		
	}

	public Customer(int customerid, int aadharno, String firstname, String lastname, int mobileno) {
		super();
		this.customerid = customerid;
		this.aadharno = aadharno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
	}

	public List<Complaint> getComplaint() {
		return complaint;
	}

	public void setComplaint(List<Complaint> complaint) {
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

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getAadharno() {
		return aadharno;
	}

	public void setAadharno(int aadharno) {
		this.aadharno = aadharno;
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

	public BankAccount getAcct() {
		return acct;
	}

	public void setAcct(BankAccount acct) {
		this.acct = acct;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", aadharno=" + aadharno + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", mobileno=" + mobileno + "]";
	}

}

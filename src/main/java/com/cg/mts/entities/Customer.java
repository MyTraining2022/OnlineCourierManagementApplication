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

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Complaint complaint;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "houseNo")
	private Address addr;

	private int mobileno;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paymentno")
	private Payment acct;

	@OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
	private List<Courier> courierSender = new ArrayList<>();

	@OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
	private List<Courier> courierReceiver = new ArrayList<>();

	public Customer() {
		super();
		this.customerid = customerid;
		this.aadharno = aadharno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.addr = addr;
		this.mobileno = mobileno;
		this.acct = acct;
	}

	public Customer(int customerid, int aadharno, String firstname, String lastname, Address addr, int mobileno,
			Payment acct) {
		super();
		this.customerid = customerid;
		this.aadharno = aadharno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.addr = addr;
		this.mobileno = mobileno;
		this.acct = acct;
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

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public int getMobileno() {
		return mobileno;
	}

	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}

	public Payment getAcct() {
		return acct;
	}

	public void setAcct(Payment acct) {
		this.acct = acct;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", aadharno=" + aadharno + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", mobileno=" + mobileno + "]";
	}

}

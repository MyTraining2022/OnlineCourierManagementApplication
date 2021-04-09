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
@Table(name ="customer")
public class Customer {
	@Id
	private int customerId;
	
	private int aadharNo;
	private String firstName;
	private String lastName;
	private int mobileNo;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Complaint> complaint=new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "addressId")
	private Address address;

	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNo")
	private BankAccount account;

	@OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
	private List<Courier> courierSender = new ArrayList<>();

	@OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
	private List<Courier> courierReceiver = new ArrayList<>();

	public Customer() {
		
		
	}

	public Customer(int customerId, int aadharNo, String firstName, String lastName, int mobileNo) {
		super();
		this.customerId = customerId;
		this.aadharNo = aadharNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(int aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public List<Complaint> getComplaint() {
		return complaint;
	}

	public void setComplaint(List<Complaint> complaint) {
		this.complaint = complaint;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
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

	

	

}

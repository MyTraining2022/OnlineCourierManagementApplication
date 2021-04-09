package com.cg.mts.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class BankAccount {
@Id
	private int accountno;
	private String accountHolderName;
	private String accountType;
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BankAccount() {
		super();
		this.accountno = accountno;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
	}
	
	public BankAccount(int accountno, String accountHolderName, String accountType) {
		super();
		this.accountno = accountno;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
	}

	public int getAccountno() {
		return accountno;
	}

	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}

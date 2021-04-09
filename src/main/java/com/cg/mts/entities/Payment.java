package com.cg.mts.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Payment {

	private int paymentno;
	private String accountHolderName;
	private String accountType;
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	

	public Payment() {
		super();
		this.paymentno = paymentno;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
	}
	
	public Payment(int paymentno, String accountHolderName, String accountType) {
		super();
		this.paymentno = paymentno;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
	}

	public int getPaymentno() {
		return paymentno;
	}

	public void setPaymentno(int paymentno) {
		this.paymentno = paymentno;
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

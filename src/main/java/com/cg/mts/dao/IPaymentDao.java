package com.cg.mts.dao;

import com.cg.mts.entities.Payment;

public interface IPaymentDao {

	public void addPayment(Payment payment);
	public Payment getPayment(int paymentId);
	
}

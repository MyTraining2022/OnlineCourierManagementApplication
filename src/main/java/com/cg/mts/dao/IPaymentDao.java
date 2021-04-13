package com.cg.mts.dao;

import com.cg.mts.entities.Payment;

public interface IPaymentDao {

	public boolean addPaymentByCash(int id);

	public Payment getPayment(int paymentId);

	public boolean addPaymentByCard(int id);

}

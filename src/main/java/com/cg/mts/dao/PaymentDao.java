package com.cg.mts.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.cg.mts.entities.Payment;
import com.cg.mts.repository.PaymentRepository;

@Component
public class PaymentDao implements IPaymentDao  {
    
	@Autowired
	PaymentRepository repo;
	@Override
	public void addPayment(Payment payment) {
		
		if(repo.existsById(payment.getPaymentId()))
			repo.save(payment);
			
		
		
	}

	@Override
	public Payment getPayment(int paymentId) {
		
		if(repo.existsById(paymentId))
			return repo.findByPaymentId(paymentId);
		
		return null;
	}
	
	

}

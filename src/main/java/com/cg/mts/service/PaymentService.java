package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Payment;
import com.cg.mts.exceptions.PaymentNotFoundException;
import com.cg.mts.repository.PaymentRepository;
@Service
public class PaymentService implements IPaymentService {

	@Autowired
	PaymentRepository repo;
	@Override
	public Payment getPaymentDetailsById(int PaymentId) {
		Optional<Payment> p = repo.findById(PaymentId);
		if (p.isPresent()) {
			return p.get();
		} else
			throw new PaymentNotFoundException("getPayment not found!");
	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		List<Payment> list = (List<Payment>) repo.findAll();

		return list;
	}

	//@Override
	public Payment PaymentByCard() {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public Payment PaymentByCash() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

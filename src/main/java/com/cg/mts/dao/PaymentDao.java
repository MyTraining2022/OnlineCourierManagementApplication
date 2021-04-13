package com.cg.mts.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.cg.mts.entities.Courier;
import com.cg.mts.entities.Payment;
import com.cg.mts.repository.CourierRepository;
import com.cg.mts.repository.PaymentRepository;

@Component
public class PaymentDao implements IPaymentDao {

	@Autowired
	PaymentRepository payRepo;
	@Autowired
	CourierRepository courRepo;

	@Override
	public Payment getPayment(int paymentId) {

		if (payRepo.existsById(paymentId))
			return payRepo.findByPaymentId(paymentId);

		return null;
	}

	@Override
	public boolean addPaymentByCash(int id) {
		if (courRepo.existsById(id)) {
			Payment payment = new Payment();
			payment.setPaymentDate(LocalDate.now());
			payment.setPaymentMode("By Cash");
			Optional<Courier> cou = courRepo.findById(id);
			payment.setCourier(cou.get());
			payRepo.save(payment);
			return true;
		}
		return false;

	}

	@Override
	public boolean addPaymentByCard(int id) {
		if (courRepo.existsById(id)) {
			Payment payment = new Payment();
			payment.setPaymentDate(LocalDate.now());
			payment.setPaymentMode("By Card");
			Optional<Courier> cou = courRepo.findById(id);
			payment.setCourier(cou.get());
			payRepo.save(payment);
			return true;
		}
		return false;

	}

}

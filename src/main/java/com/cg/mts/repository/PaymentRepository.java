package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
	Payment findByPaymentId(int id);

}

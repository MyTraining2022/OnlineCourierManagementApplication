package com.cg.mts.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int paymentid;
	private String paymentmode;
	private LocalDate paymentdate;
	
	
	

}

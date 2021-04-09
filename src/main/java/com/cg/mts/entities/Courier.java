package com.cg.mts.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="courier")
public class Courier {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int courierId;
	
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int consignmentNo;
	
	private LocalDate initiatedDate;
	private CourierStatus status;
	private LocalDate deliveredDate;
	
	@ManyToOne
	//@JoinColumn(name= "customer_id")
	private Customer sender;
	
	@ManyToOne
	//@JoinColumn(name= "customer_id")
	private Customer receiver;
	
	@OneToOne
	@JoinColumn(name="paymentId")
	private Payment payment;
	
	public Courier() {
		
	}

	public Courier(CourierStatus status, LocalDate initiatedDate,LocalDate deliveredDate) {
		super();
		
		this.status = status;
		this.initiatedDate = initiatedDate;
		this.deliveredDate = deliveredDate;
	}

	
	public int getCourierId() {
		return courierId;
	}

	public void setCourierId(int courierId) {
		this.courierId = courierId;
	}

	public int getConsignmentNo() {
		return consignmentNo;
	}

	public void setConsignmentNo(int consignmentNo) {
		this.consignmentNo = consignmentNo;
	}

	public LocalDate getInitiatedDate() {
		return initiatedDate;
	}

	public void setInitiatedDate(LocalDate initiatedDate) {
		this.initiatedDate = initiatedDate;
	}

	public CourierStatus getStatus() {
		return status;
	}

	public void setStatus(CourierStatus status) {
		this.status = status;
	}

	public LocalDate getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(LocalDate deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public Customer getSender() {
		return sender;
	}

	public void setSender(Customer sender) {
		this.sender = sender;
	}

	public Customer getReceiver() {
		return receiver;
	}

	public void setReceiver(Customer receiver) {
		this.receiver = receiver;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	
	
	
	

}

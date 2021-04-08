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
	private int courierid;
	
	private CourierStatus status;
	
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int consignmentno;
	
	private LocalDate initiatedDate;
	private LocalDate deliveredDate;
	
	@ManyToOne
	@JoinColumn(name= "customer_id")
	private Customer sender;
	
	@ManyToOne
	@JoinColumn(name= "customer_id")
	private Customer receiver;
	
	public Courier() {
		super();
	}
	
	
	public Courier(int courierid, CourierStatus status, int consignmentno, LocalDate initiatedDate,
			LocalDate deliveredDate) {
		super();
		this.courierid = courierid;
		this.status = status;
		this.consignmentno = consignmentno;
		this.initiatedDate = initiatedDate;
		this.deliveredDate = deliveredDate;
	}

	public int getCourierid() {
		return courierid;
	}
	public void setCourierid(int courierid) {
		this.courierid = courierid;
	}
	public CourierStatus getStatus() {
		return status;
	}
	public void setStatus(CourierStatus status) {
		this.status = status;
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
	public int getConsignmentno() {
		return consignmentno;
	}
	public void setConsignmentno(int consignmentno) {
		this.consignmentno = consignmentno;
	}
	public LocalDate getInitiatedDate() {
		return initiatedDate;
	}
	public void setInitiatedDate(LocalDate initiatedDate) {
		this.initiatedDate = initiatedDate;
	}
	public LocalDate getDeliveredDate() {
		return deliveredDate;
	}
	public void setDeliveredDate(LocalDate deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	@Override
	public String toString() {
		return "Courier [Courier ID=" + courierid + ", Status=" + status + ", Consignment No=" + consignmentno
				+ ", Initiated Date=" + initiatedDate + ", Delivered Date=" + deliveredDate + ", Sender=" + sender
				+ ", Receiver=" + receiver + "]";
	}


}

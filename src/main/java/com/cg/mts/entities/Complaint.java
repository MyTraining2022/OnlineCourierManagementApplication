package com.cg.mts.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="complaint")
public class Complaint {

	@Id
	private int complaintid;
	private int consignmentno;
	private String shortdescription;
	private String detaildescription;
	
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customer;

	public Complaint() {
		
	}
	
	
	
	public Complaint(int complaintid, int consignmentno, String shortdescription, String detaildescription) {
		super();
		this.complaintid = complaintid;
		this.consignmentno = consignmentno;
		this.shortdescription = shortdescription;
		this.detaildescription = detaildescription;
	}

	public int getComplaintid() {
		return complaintid;
	}

	public void setComplaintid(int complaintid) {
		this.complaintid = complaintid;
	}

	public int getConsignmentno() {
		return consignmentno;
	}

	public void setConsignmentno(int consignmentno) {
		this.consignmentno = consignmentno;
	}

	public String getShortdescription() {
		return shortdescription;
	}

	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}

	public String getDetaildescription() {
		return detaildescription;
	}

	public void setDetaildescription(String detaildescription) {
		this.detaildescription = detaildescription;
	}
	
	
	
	

}

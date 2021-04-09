package com.cg.mts.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@Table(name="manager")
//@DiscriminatorValue("MGR")
public class Manager extends OfficeStaffMember {
	
	
	
	@ManyToOne
	@JoinColumn(name="officeid")
	private CourierOfficeOutlet office;
	public Manager() {
		
	}

	
	
	
}

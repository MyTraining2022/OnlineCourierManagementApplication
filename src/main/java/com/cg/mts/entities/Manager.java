package com.cg.mts.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@Table(name="manager")
//@DiscriminatorValue("MGR")
public class Manager extends OfficeStaffMember {
	
	@Id
	private int managerId;
	private String mangName;
	
	
	@OneToMany(mappedBy="mgr",cascade=CascadeType.ALL)
	private List<OfficeStaffMember> reportingstaffmembers;
	
	
	public Manager() {
		
	}

	public Manager(int managerId, String mangName) {
		super();
		this.managerId = managerId;
		this.mangName = mangName;
	}

	public List<OfficeStaffMember> getReportingstaffmembers() {
		return reportingstaffmembers;
	}

	public void setReportingstaffmembers(List<OfficeStaffMember> reportingstaffmembers) {
		this.reportingstaffmembers = reportingstaffmembers;
	}
	
	
}

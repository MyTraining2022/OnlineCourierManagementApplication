package com.cg.mts.service;

import java.util.List;

import com.cg.mts.entities.Complaint;
import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.OfficeStaffMember;
//import com.cg.mts.exception.ComplaintNotFoundException;
//import com.cg.mts.exception.CourierNotFoundException;
//import com.cg.mts.exception.StaffMemberNotFoundException;
import com.cg.mts.exceptions.StaffMemberNotFoundException;

public interface IManagerService {

	public OfficeStaffMember addStaffMember(OfficeStaffMember staffmember);
	public void removeStaffMember(OfficeStaffMember staffmember);
	
	public OfficeStaffMember getStaffMember(int empid) throws StaffMemberNotFoundException; //throws StaffMemberNotFoundException;
	public List<OfficeStaffMember> getAllStaffMembers(int officeId);
	
	public String getCourierStatus(Courier courier); //throws CourierNotFoundException;
	
	public Complaint getRegistedComplaint(int complaintid) ;//throws ComplaintNotFoundException;
	public List<Complaint> getAllComplaints();
}

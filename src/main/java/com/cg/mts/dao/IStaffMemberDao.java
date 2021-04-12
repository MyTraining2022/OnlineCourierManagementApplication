package com.cg.mts.dao;

import java.util.List;

import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exceptions.StaffMemberNotFoundException;

public interface IStaffMemberDao {
	
	public void addStaffMember(OfficeStaffMember staffMember);
	public void removeStaffMember(OfficeStaffMember staffMember);
	public OfficeStaffMember getStaffMember(int empId) throws StaffMemberNotFoundException;
	public List<OfficeStaffMember> getAllStaffMembers();

}

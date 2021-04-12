package com.cg.mts.dao;

import java.util.List;

import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exceptions.DuplicateStaffMemberFoundException;
import com.cg.mts.exceptions.StaffMemberNotFoundException;


public interface IStaffMemberDao {
	
	public boolean addStaffMember(OfficeStaffMember staffmember) throws DuplicateStaffMemberFoundException ;
	public boolean removeStaffMember(int id) throws  StaffMemberNotFoundException ;
	
	public OfficeStaffMember getStaffMember(int empid) throws StaffMemberNotFoundException;
	
	
	

}

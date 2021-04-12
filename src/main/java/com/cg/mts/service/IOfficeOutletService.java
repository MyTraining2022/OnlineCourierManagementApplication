package com.cg.mts.service;

import java.util.List;

import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exceptions.OutletClosedException;
import com.cg.mts.exceptions.OutletNotFoundException;
import com.cg.mts.exceptions.StaffMemberNotFoundException;

public interface IOfficeOutletService {
	
	public void addNewOffice(CourierOfficeOutlet officeOutlet);
	public void removeNewOffice(CourierOfficeOutlet officeOutlet);
	public CourierOfficeOutlet getOfficeInfo(int officeId) throws OutletNotFoundException;
	public List<OfficeStaffMember> getStaffMembersByOfficeId(int officeId) throws OutletNotFoundException; 
	public List<CourierOfficeOutlet> getAllOfficesData();
	
	public boolean isOfficeOpen(CourierOfficeOutlet officeOutlet) throws OutletClosedException;
	public boolean isOfficeClosed(CourierOfficeOutlet officeOutlet);
	
}

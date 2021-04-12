package com.cg.mts.dao;

import java.util.List;

import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exceptions.OutletNotFoundException;

public interface IOfficeOutletDao {

	public void addNewOffice(CourierOfficeOutlet officeOutlet);
	public void removeNewOffice(CourierOfficeOutlet officeOutlet);
	public CourierOfficeOutlet getOfficeInfo(int officeId) throws OutletNotFoundException;
	public List<CourierOfficeOutlet> getAllOfficesData();
}

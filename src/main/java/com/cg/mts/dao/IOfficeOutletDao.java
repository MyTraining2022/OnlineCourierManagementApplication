package com.cg.mts.dao;

import java.util.List;

import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exception.OutletNotFoundException;

public interface IOfficeOutletDao {

	public boolean addNewOffice(CourierOfficeOutlet officeOutlet);
	public CourierOfficeOutlet getOfficeInfo(int officeId) throws OutletNotFoundException;
	public List<CourierOfficeOutlet> getAllOfficesData();
	public boolean removeNewOffice(int officeId);
}

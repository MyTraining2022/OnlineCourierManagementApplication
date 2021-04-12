package com.cg.mts.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.dao.OfficeOutletDao;
import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exceptions.OutletClosedException;
import com.cg.mts.exceptions.OutletNotFoundException;

@Service
public class OfficeOutletService implements IOfficeOutletService {

	@Autowired
	OfficeOutletDao officeDao;
	
	@Override
	public void addNewOffice(CourierOfficeOutlet officeOutlet) {
		
		officeDao.addNewOffice(officeOutlet);
	}

	@Override
	public void removeNewOffice(CourierOfficeOutlet officeOutlet) {
		
		officeDao.removeNewOffice(officeOutlet);
	}

	@Override
	public CourierOfficeOutlet getOfficeInfo(int officeId) throws OutletNotFoundException {
		
		return officeDao.getOfficeInfo(officeId);
	}
	
	@Override
	public List<OfficeStaffMember> getStaffMembersByOfficeId(int officeId) throws OutletNotFoundException {
		
		return officeDao.getOfficeInfo(officeId).getStaffMembers();
	}

	@Override
	public List<CourierOfficeOutlet> getAllOfficesData() {
		
		return officeDao.getAllOfficesData();
	}

	@Override
	public boolean isOfficeOpen(CourierOfficeOutlet officeOutlet) throws OutletClosedException {
		if(!(officeOutlet.getOpeningTime() == LocalTime.now())) {
			throw new OutletClosedException("Office  is already closed");
		}
		return true;
	}

	@Override
	public boolean isOfficeClosed(CourierOfficeOutlet officeOutlet) {
		if(officeOutlet.getClosingTime() == LocalTime.now())
			return true;
		return false;
	}

}

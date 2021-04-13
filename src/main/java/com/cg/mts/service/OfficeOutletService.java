package com.cg.mts.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.dao.IOfficeOutletDao;
import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exceptions.OutletClosedException;
import com.cg.mts.exceptions.OutletNotFoundException;

@Service
public class OfficeOutletService implements IOfficeOutletService {

	@Autowired
	IOfficeOutletDao officeDao;
	
	@Override
	public boolean addNewOffice(CourierOfficeOutlet officeOutlet) {
		
		return officeDao.addNewOffice(officeOutlet);
	}

	@Override
	public boolean removeNewOffice(int officeId) {
		
		return officeDao.removeNewOffice(officeId);
	}

	@Override
	public CourierOfficeOutlet getOfficeInfo(int officeId) throws OutletNotFoundException {
		
		return officeDao.getOfficeInfo(officeId);
	}
	
	@Override
	public List<CourierOfficeOutlet> getAllOfficesData() {
		
		return officeDao.getAllOfficesData();
	}

	@Override
	public boolean isOfficeOpen(CourierOfficeOutlet officeOutlet) throws OutletClosedException {
		if(LocalTime.now().isAfter(officeOutlet.getOpeningTime()) && LocalTime.now().isBefore(officeOutlet.getClosingTime())) {
			return true;
		}
		throw new OutletClosedException("Courier Office is closed");
	}

	@Override
	public boolean isOfficeClosed(CourierOfficeOutlet officeOutlet) throws OutletClosedException {
		if(LocalTime.now().isBefore(officeOutlet.getOpeningTime()) && LocalTime.now().isAfter(officeOutlet.getClosingTime()))
			throw new OutletClosedException("Courier Office is closed");
		return false;
	}

}

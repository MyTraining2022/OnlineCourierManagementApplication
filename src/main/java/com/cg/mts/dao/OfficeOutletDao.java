package com.cg.mts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exception.OutletNotFoundException;
import com.cg.mts.repository.OfficeOutletRepository;

@Component
public class OfficeOutletDao implements IOfficeOutletDao{

	@Autowired
	OfficeOutletRepository officeRepo;
	
	@Override
	public boolean addNewOffice(CourierOfficeOutlet officeOutlet) {
		if(!officeRepo.existsById(officeOutlet.getOfficeId())) {
			officeRepo.save(officeOutlet);
			return true;
		}
		return false;
	}

	@Override
	public CourierOfficeOutlet getOfficeInfo(int officeId) throws OutletNotFoundException {
		if(!(officeRepo.existsById(officeId)))
			throw new OutletNotFoundException("Courier Office with id "+ officeId +" doesn't exist");
		return officeRepo.findByOfficeId(officeId);
	}

	@Override
	public List<CourierOfficeOutlet> getAllOfficesData() {
		
		return officeRepo.findAll();
	}

	@Override
	public boolean removeNewOffice(int officeId) {
		if(officeRepo.existsById(officeId)) {
			officeRepo.deleteById(officeId);
			return true;
		}
		return false;
	}

}

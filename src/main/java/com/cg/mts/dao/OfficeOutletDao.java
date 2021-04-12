package com.cg.mts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exceptions.OutletNotFoundException;
import com.cg.mts.repository.CourierOfficeOutletRepository;

@Component
public class OfficeOutletDao implements IOfficeOutletDao{

	@Autowired
	CourierOfficeOutletRepository officeRepo;
	
	@Override
	public void addNewOffice(CourierOfficeOutlet officeOutlet) {
		if(!officeRepo.existsById(officeOutlet.getOfficeId()))
			officeRepo.save(officeOutlet);
		
	}

	@Override
	public void removeNewOffice(CourierOfficeOutlet officeOutlet) {
		
		if(officeRepo.existsById(officeOutlet.getOfficeId()))
			officeRepo.deleteById(officeOutlet.getOfficeId());
		
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

}

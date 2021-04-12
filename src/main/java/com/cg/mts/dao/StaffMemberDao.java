package com.cg.mts.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exceptions.StaffMemberNotFoundException;
import com.cg.mts.repository.StaffMemberRepository;

@Component
public class StaffMemberDao implements IStaffMemberDao {

	@Autowired
	StaffMemberRepository staffRepo;
	
	@Override
	public void addStaffMember(OfficeStaffMember staffMember) {
	
		if(!staffRepo.existsById(staffMember.getEmpId()))
			staffRepo.save(staffMember);
		
	}

	@Override
	public void removeStaffMember(OfficeStaffMember staffMember) {
		
		if(staffRepo.existsById(staffMember.getEmpId()))
			staffRepo.deleteById(staffMember.getEmpId());
		
	}

	@Override
	public OfficeStaffMember getStaffMember(int empId) throws StaffMemberNotFoundException {
		
		if(!(staffRepo.existsById(empId)))
			throw new StaffMemberNotFoundException("Staff Member with Id "+ empId + " doesn't exist");
		return staffRepo.findByEmpId(empId);
	}

	@Override
	public List<OfficeStaffMember> getAllStaffMembers() {

		return staffRepo.findAll();
	}

}

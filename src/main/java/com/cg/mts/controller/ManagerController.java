package com.cg.mts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exceptions.DuplicateStaffMemberFoundException;
import com.cg.mts.exceptions.StaffMemberNotFoundException;
import com.cg.mts.service.ManagerServiceImp;


@RestController
@RequestMapping("manager")
public class ManagerController {
	
	@Autowired
	ManagerServiceImp managerservice;
	
	
	
	@PostMapping
	public String addStaff(@RequestBody  OfficeStaffMember staffmember) {
		
		if(managerservice.addStaffMember(staffmember))
		return "Added successfully";
		else {
			throw new DuplicateStaffMemberFoundException(" Staff Member with id "+staffmember.getEmpId()+" is already exists.");
		}
		
	}
	
	
	@DeleteMapping("/{eid}")
	public String  deleteStaff(@PathVariable("eid") int id) {
		if(managerservice.removeStaffMember(id)) {
			return "Delete successfull";
		}else
			throw new StaffMemberNotFoundException("Delete  Employee with id "+id+" not found.");
	}

}

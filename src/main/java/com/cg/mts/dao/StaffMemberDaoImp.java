package com.cg.mts.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exceptions.DuplicateStaffMemberFoundException;
import com.cg.mts.exceptions.StaffMemberNotFoundException;
import com.cg.mts.repository.StaffMemberRepository;


@Component
public class StaffMemberDaoImp implements IStaffMemberDao {
	
	@Autowired
	StaffMemberRepository staffReposi;

	@Override
	public boolean addStaffMember(OfficeStaffMember staffmember) throws DuplicateStaffMemberFoundException {
		if(staffReposi.existsById(staffmember.getEmpId())) {
			throw new DuplicateStaffMemberFoundException("Staff id "+staffmember.getEmpId()+" is present in database." );
		}else {
			
			staffReposi.save(staffmember);
			return true;
		}
		
		
	}
	
	@Override
	public boolean removeStaffMember(int id)  {
		
			if(staffReposi.existsById(id)) {
				staffReposi.deleteById(id);
				return true;
			}else {
				throw new StaffMemberNotFoundException("Staff id "+id+" is not present in database." );
			}
		}

	
	@Override
	public OfficeStaffMember getStaffMember(int empid)  {
		Optional<OfficeStaffMember> osm = staffReposi.findById(empid);
		if(osm.isPresent()) {
			return osm.get();
		}else {
			throw new StaffMemberNotFoundException("Staff id "+ empid+" is present  not in database." );
		}
	}


	

}

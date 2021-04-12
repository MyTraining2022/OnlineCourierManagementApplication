package com.cg.mts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.dao.IStaffMemberDao;
import com.cg.mts.dao.StaffMemberDao;
import com.cg.mts.entities.Complaint;
import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exceptions.StaffMemberNotFoundException;
import com.cg.mts.repository.ComplaintRepository;
import com.cg.mts.repository.CourierOfficeOutletRepository;
import com.cg.mts.repository.CourierRepository;
import com.cg.mts.repository.StaffMemberRepository;

@Service
public class ManagerService implements IManagerService{

	@Autowired
	StaffMemberRepository StaffMemberRepo;
	
	@Autowired
	CourierRepository courierRepo;
	
	@Autowired
	ComplaintRepository complaintRepo;
	
	@Autowired
	CourierOfficeOutletRepository  CourierOfficeOutletRepo;
	
	@Autowired
	StaffMemberDao  dao;
	
	
	
	@Override
	public OfficeStaffMember addStaffMember(OfficeStaffMember staffmember) {
		
		if(StaffMemberRepo.existsById(staffmember.getEmpId())) {
			
		}
		StaffMemberRepo.save(staffmember);
		
		return staffmember;
		
	}

	@Override
	public void removeStaffMember(OfficeStaffMember staffmember) {
		StaffMemberRepo.deleteById(staffmember.getEmpId());
		
	}

	@Override
	public OfficeStaffMember getStaffMember(int empid) throws StaffMemberNotFoundException {
		return dao.getStaffMember(empid);
		
	}

	@Override
	public List<OfficeStaffMember> getAllStaffMembers(int officeId) {
		/*List<OfficeStaffMember> lst = new ArrayList<>();
		if(CourierOfficeOutletRepo.existsById(officeId)) {
			if(StaffMemberRepo.)
		}*/
		return null;
	}

	@Override
	public String getCourierStatus(Courier courier) {
		String str = null;
		if(courierRepo.existsById(courier.getCourierId())) {
			str = courier.getStatus().toString();
			return str;
		}
		
		return str;
		
	}

	@Override
	public Complaint getRegistedComplaint(int complaintid) {
		Optional<Complaint> complaint = complaintRepo.findById(complaintid);
		if(complaint.isPresent()) {
			return complaint.get();
		}
		return null;
	}

	@Override
	public List<Complaint> getAllComplaints() {
		List<Complaint> lst = complaintRepo.findAll();
		if(lst.isEmpty()) {
			return null;
		}
		return lst;
	}

}

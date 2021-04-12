package com.cg.mts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.dao.IStaffMemberDao;
import com.cg.mts.dao.StaffMemberDaoImp;
import com.cg.mts.entities.Complaint;
import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exceptions.CourierNotFoundException;
import com.cg.mts.exceptions.DuplicateStaffMemberFoundException;
import com.cg.mts.exceptions.StaffMemberNotFoundException;
import com.cg.mts.repository.ComplaintRepository;
import com.cg.mts.repository.CourierOfficeOutletRepository;
import com.cg.mts.repository.CourierRepository;
import com.cg.mts.repository.StaffMemberRepository;

@Service
public class ManagerServiceImp implements IManagerService{

	@Autowired
	StaffMemberRepository StaffMemberRepo;
	
	@Autowired
	CourierRepository courierRepo;
	
	@Autowired
	ComplaintRepository complaintRepo;
	
	@Autowired
	CourierOfficeOutletRepository  CourierOfficeOutletRepo;
	
	@Autowired
	StaffMemberDaoImp  StaffMemberDao;
	
	@Autowired
	StaffMemberRepository staffReposi;
	
	@Override
	public boolean addStaffMember(OfficeStaffMember staffmember) {
		
		if(StaffMemberRepo.existsById(staffmember.getEmpId())) {
			throw new DuplicateStaffMemberFoundException("Staff id "+staffmember.getEmpId()+" is present in database." );
		}
		else {
			StaffMemberRepo.save(staffmember);
			return true;
		}
	}

	@Override
	public boolean removeStaffMember(int id) {
		
		return StaffMemberDao.removeStaffMember(id);
		
		/*if(StaffMemberRepo.existsById(id)) {
			StaffMemberRepo.deleteById(id);
			return true;
		}
		else {
			throw new StaffMemberNotFoundException("Staff id "+id+" is not present in database." );
		}*/
		
		
	
	}

	@Override
	public OfficeStaffMember getStaffMember(int empid) throws StaffMemberNotFoundException {
		return StaffMemberDao.getStaffMember(empid);
		
	}


	@Override
	public CourierStatus getCourierStatus(int courierId)  {
		
		/*if(!(courierRepo.existsById(courier.getCourierId()))) {
			return null ;
		} 
		else {
			return courierRepo.getStatus(courier.getCourierId());
		}*/
		
		Optional<Courier> courier = courierRepo.findById(courierId);
		if(courier.isPresent()) {
			return courier.get().getStatus();
		}
		else {
			return null;
		}
		
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
		List<Complaint> lst = (List<Complaint>) complaintRepo.findAll();
		if(lst.isEmpty()) {
			return null;
		}
		return lst;
	}

}

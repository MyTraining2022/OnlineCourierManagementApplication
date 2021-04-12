package com.cg.mts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Complaint;
import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exceptions.ComplaintNotFoundException;
import com.cg.mts.exceptions.CourierNotFoundException;
import com.cg.mts.exceptions.DuplicateStaffMemberFoundException;
import com.cg.mts.exceptions.StaffMemberNotFoundException;
import com.cg.mts.repository.ComplaintRepository;
import com.cg.mts.repository.CourierRepository;
import com.cg.mts.service.ManagerServiceImp;



@RestController
@RequestMapping("manager")
public class ManagerController {
	
	@Autowired
	ManagerServiceImp managerservice;
	
	@Autowired
	CourierRepository courierRepo;
	
	@Autowired
	ComplaintRepository complaintRepo;
	
	
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

	
	
	@GetMapping("{id}")
	public ResponseEntity<?> getStaffMemberDetails(@PathVariable("id")int empid) {
		OfficeStaffMember staff =   managerservice.getStaffMember(empid) ;
		if(staff==null) {
			throw new StaffMemberNotFoundException("Staff memeber is not  found with id "+empid);
		}
		else {
			return new ResponseEntity<OfficeStaffMember>(staff,HttpStatus.OK);
		}
	} 
	
	@GetMapping(value="/filterBy/id_type/CourierStatus/{cid}")
	public ResponseEntity<?> getCourierStatus(@PathVariable(name= "cid")int courierId) {
		/*Optional<Courier> courier = courierRepo.findById(courierId);
		if(courier.isEmpty()) {
			throw new CourierNotFoundException("CourierId is not in database"+courierId);
		}
		
		return new ResponseEntity<CourierStatus>(courier.get().getStatus(),HttpStatus.OK);
		*/
		if(managerservice.getCourierStatus(courierId)) {
			Optional<Courier> courier = courierRepo.findById(courierId);
			return new ResponseEntity<CourierStatus>(courier.get().getStatus(),HttpStatus.OK);
		}else {
			throw new CourierNotFoundException("CourierId is not in database"+courierId);
		}
		
		
	}
	
	@GetMapping(value="/filterBy/id_type/complaint/{cid}")
	public Complaint getRegistedComplaint(@PathVariable(name= "cid")int complaintId) {
		/*Optional<Complaint> complaint = complaintRepo.findById(complaintId);
		if(complaint.isEmpty()) {
			throw new ComplaintNotFoundException("ComplaintId is not in database"+complaintId,"Not found");
		}
		else {
			return complaint.get();
		}*/
		
		if(managerservice.getRegistedComplaint(complaintId)) {
			Optional<Complaint> complaint = complaintRepo.findById(complaintId);
			return complaint.get();
		}
		else {
			throw new ComplaintNotFoundException("ComplaintId is not in database"+complaintId,"Not found");
		}
	}
	
	@GetMapping
	public List<Complaint> getAllComplaints(){
		List<Complaint> complaints = managerservice.getAllComplaints();
		if(complaints.isEmpty()) {
			throw new ComplaintNotFoundException("No Complaints","Good Job");
		}
		else {
			return complaints;
		}
	}
	
	
}

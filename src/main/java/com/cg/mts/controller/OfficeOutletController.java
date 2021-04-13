package com.cg.mts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exceptions.OutletClosedException;
import com.cg.mts.exceptions.OutletNotFoundException;
import com.cg.mts.service.OfficeOutletService;

@RestController
@RequestMapping("CourierOfficeOutlet")
public class OfficeOutletController {

	@Autowired
	OfficeOutletService oos;
	
	@GetMapping("{oid}")
	public ResponseEntity<?> getOfficeData(@PathVariable("oid") int officeId) throws OutletNotFoundException {
	
		CourierOfficeOutlet coo= oos.getOfficeInfo(officeId);
		if(coo==null)
			return new ResponseEntity<String>("Courier Office with id "+ officeId +" not found", HttpStatus.NOT_FOUND);
		else {
			return new ResponseEntity<CourierOfficeOutlet>(coo, HttpStatus.FOUND);
		}
	}
	
	@GetMapping
	public List<CourierOfficeOutlet> getAllOfficesInfo(){
		
		return oos.getAllOfficesData();
	}
	
	@PostMapping
	public String addOffice(@RequestBody CourierOfficeOutlet coo) {
		if(oos.addNewOffice(coo))
			return "New Courier Office successfully added";
		else
			return "Courier Office already exist";
	}
	
	@DeleteMapping("{oid}")
	public String removeOffice(@PathVariable("oid") int officeId) {
		
		if(oos.removeNewOffice(officeId))
			return "Courier Office data successfully deleted";
		else
			return "Courier Office data to delete not found";
	}
	
	@GetMapping("/office")
	public String checkOfficeStatus(int officeId) throws OutletClosedException, OutletNotFoundException {
		CourierOfficeOutlet coo= oos.getOfficeInfo(officeId);
		if(oos.isOfficeOpen(coo))
			return "Courier Office is open";
		else if(oos.isOfficeClosed(coo))
			return "Courier Office is closed";
		else
			return "Courier Office is open";
	}
}

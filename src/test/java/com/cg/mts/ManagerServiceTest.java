package com.cg.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.entities.Address;
import com.cg.mts.entities.Complaint;
import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.entities.Manager;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exceptions.CourierNotFoundException;
import com.cg.mts.exceptions.StaffMemberNotFoundException;
import com.cg.mts.repository.ComplaintRepository;
import com.cg.mts.repository.CourierRepository;
import com.cg.mts.repository.StaffMemberRepository;
import com.cg.mts.service.ManagerServiceImp;

@SpringBootTest
class ManagerServiceTest {

	@Autowired
	ManagerServiceImp  managerServices;
	
	
	@MockBean
	CourierRepository courierRepo;
	
	@MockBean
	StaffMemberRepository staffMemberRepo;
	
	@MockBean
	ComplaintRepository complaintRepo;
	
	
	
	@Test
	@DisplayName("Test for adding Staff")
	public void addStaff() {
		OfficeStaffMember staff = new OfficeStaffMember();
		Address address = new Address("12c","MG Road","Motihari","Bihar","India",845401);
		CourierOfficeOutlet office = new CourierOfficeOutlet(112,LocalTime.of(10, 00),LocalTime.of(05, 00));
		OfficeStaffMember staff1 = new OfficeStaffMember(111,"Amit","Mgr");
		
		staff.setEmpId(118);
		staff.setName("Amit");
		staff.setRole("emp");
		staff.setAddress(address);
		staff.setOffice(office);
		staff.setManager(staff1);
		
		when(staffMemberRepo.save(staff)).thenReturn(staff);
		assertEquals(true, managerServices.addStaffMember(staff));
		
	}
	
	
	@Test
	@DisplayName("Test for deleting staff")
	public void removeStaff() {
		OfficeStaffMember staff = new OfficeStaffMember();
		Address address = new Address("12c","MG Road","Motihari","Bihar","India",845401);
		CourierOfficeOutlet office = new CourierOfficeOutlet(112,LocalTime.of(10, 00),LocalTime.of(05, 00));
		OfficeStaffMember staff1 = new OfficeStaffMember(111,"Amit","Mgr");
		
		staff.setEmpId(118);
		staff.setName("Amit");
		staff.setRole("emp");
		staff.setAddress(address);
		staff.setOffice(office);
		staff.setManager(staff1);
		
		//managerServices.removeStaffMember(118);
		if(staffMemberRepo.existsById(staff.getEmpId())) {
			 verify(staffMemberRepo, times(1)).deleteById(staff.getEmpId());
			 assertEquals(true, managerServices.removeStaffMember(staff.getEmpId()));
		}
	   
		
		
	}
	
	@Test
	@DisplayName("Test for get staff")
	public void getStaff() {
		OfficeStaffMember staff = new OfficeStaffMember();
		Address address = new Address("12c","MG Road","Motihari","Bihar","India",845401);
		CourierOfficeOutlet office = new CourierOfficeOutlet(112,LocalTime.of(10, 00),LocalTime.of(05, 00));
		OfficeStaffMember staff1 = new OfficeStaffMember(111,"Amit","Mgr");
		
		staff.setEmpId(118);
		staff.setName("Amit");
		staff.setRole("emp");
		staff.setAddress(address);
		staff.setOffice(office);
		staff.setManager(staff1);
		
		when(staffMemberRepo.findById(118)).thenReturn(Optional.of(staff));
		assertEquals(staff, managerServices.getStaffMember(118));

	}

	@Test
	@DisplayName("Test to get courier status")
	public void getCourierStatus() {
		
		Courier courier1= new Courier();
		
		courier1.setCourierId(111);
		//courier1.setConsignmentNo(112);
		courier1.setStatus(CourierStatus.delivered);
		courier1.setInitiatedDate(LocalDate.of(2018, 11, 16));
		courier1.setDeliveredDate(LocalDate.of(2018, 11, 28));
		
		
		when(courierRepo.save(courier1)).thenReturn(courier1);
		if(courierRepo.existsById(courier1.getCourierId())) {
		assertEquals(courier1.getStatus(), managerServices.getCourierStatus(courier1.getCourierId()));
		}
		
	}
	
	@Test
	@DisplayName("Test to get Registed Complaint")
	public void getRegistedComplaint() {
		Complaint complaint = new Complaint();
		complaint.setComplaintId(1);
		complaint.setShortDescription("Item is Not Delivered");
		complaint.setShortDescription("Deliveriy date Was 28/02/2021 butstill 1 month , my parcel is not delivered ");
		
		
		
		when(complaintRepo.findById(1)).thenReturn(Optional.of(complaint));
		assertEquals(true, managerServices.getRegistedComplaint(1));
	}
	
	@Test
	@DisplayName("Test to get all Registed Complaint")
	public void getAllRegistedComplaint() {
		
		when(complaintRepo.findAll()).thenReturn(Stream.of(
				new Complaint("Item is Not Delivered","Deliveriy date Was 28/02/2021 butstill 1 month , my parcel is not delivered "),
				new Complaint("Item is Not Delivered","Deliveriy date Was 28/02/2021 butstill 1 month , my parcel is not delivered "))
				.collect(Collectors.toList()));

		assertEquals(2, managerServices.getAllComplaints().size());

	}
	


}

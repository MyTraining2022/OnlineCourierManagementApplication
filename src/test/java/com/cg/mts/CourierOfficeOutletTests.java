package com.cg.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.entities.Address;
import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exception.OutletClosedException;
import com.cg.mts.exception.OutletNotFoundException;
import com.cg.mts.repository.OfficeOutletRepository;
import com.cg.mts.service.OfficeOutletService;

@SpringBootTest
class CourierOfficeOutletTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private OfficeOutletService oos;

	@MockBean
	private OfficeOutletRepository officeRepo;

	@Test
	public void addingNewOfficeTest() {

		CourierOfficeOutlet coo = new CourierOfficeOutlet(100, LocalTime.of(9, 0), LocalTime.of(18, 0));
		List<OfficeStaffMember> list = new ArrayList<>();
		list.add(new OfficeStaffMember(101, "Arun", "EMP"));
		list.add(new OfficeStaffMember(102, "Tarun", "EMP"));
		list.add(new OfficeStaffMember(103, "Arjun", "MGR"));
		Address addr = new Address("1BC", "Ravi Street", "Sambalpur", "Odisha", "India", 768220);

		coo.setStaffMembers(list);
		coo.setAddress(addr);

		when(officeRepo.save(coo)).thenReturn(coo);
		assertEquals(true, oos.addNewOffice(coo));
	}

	@Test
	public void removingOfficeTest() {

		CourierOfficeOutlet coo = new CourierOfficeOutlet(200, LocalTime.of(10, 0), LocalTime.of(20, 0));
		List<OfficeStaffMember> list = new ArrayList<>();
		list.add(new OfficeStaffMember(101, "Arun", "EMP"));
		list.add(new OfficeStaffMember(102, "Tarun", "EMP"));
		list.add(new OfficeStaffMember(103, "Arjun", "MGR"));
		Address addr = new Address("1BC", "Ravi Street", "Sambalpur", "Odisha", "India", 768220);

		coo.setStaffMembers(list);
		coo.setAddress(addr);

		if (officeRepo.existsById(coo.getOfficeId())) {
			verify(officeRepo, times(1)).deleteById(coo.getOfficeId());
			assertEquals(true, oos.removeNewOffice(coo.getOfficeId()));
		}
	}

	@Test
	public void getOfficeTest() throws OutletNotFoundException {

		CourierOfficeOutlet coo = new CourierOfficeOutlet(200, LocalTime.of(10, 0), LocalTime.of(20, 0));
		List<OfficeStaffMember> list = new ArrayList<>();
		list.add(new OfficeStaffMember(101, "Arun", "EMP"));
		list.add(new OfficeStaffMember(102, "Tarun", "EMP"));
		list.add(new OfficeStaffMember(103, "Arjun", "MGR"));
		Address addr = new Address("1BC", "Ravi Street", "Sambalpur", "Odisha", "India", 768220);

		coo.setStaffMembers(list);
		coo.setAddress(addr);

		if (officeRepo.existsById(coo.getOfficeId())) {
			when(officeRepo.findByOfficeId(coo.getOfficeId())).thenReturn(coo);
			assertEquals(coo, oos.getOfficeInfo(coo.getOfficeId()));
		}
	}

	@Test
	public void getAllOfficesTest() {

		CourierOfficeOutlet coo1 = new CourierOfficeOutlet(200, LocalTime.of(10, 0), LocalTime.of(20, 0));
		CourierOfficeOutlet coo2 = new CourierOfficeOutlet(300, LocalTime.of(11, 0), LocalTime.of(21, 0));
		CourierOfficeOutlet coo3 = new CourierOfficeOutlet(400, LocalTime.of(12, 0), LocalTime.of(22, 0));

		List<OfficeStaffMember> list1 = new ArrayList<>();
		list1.add(new OfficeStaffMember(101, "Arun", "EMP"));
		list1.add(new OfficeStaffMember(102, "Tarun", "EMP"));
		list1.add(new OfficeStaffMember(103, "Arjun", "MGR"));
		Address addr1 = new Address("1BC", "Ravi Street", "Sambalpur", "Odisha", "India", 768220);

		coo1.setStaffMembers(list1);
		coo1.setAddress(addr1);

		List<OfficeStaffMember> list2 = new ArrayList<>();
		list2.add(new OfficeStaffMember(104, "Arun", "EMP"));
		list2.add(new OfficeStaffMember(105, "Tarun", "EMP"));
		list2.add(new OfficeStaffMember(106, "Arjun", "MGR"));
		Address addr2 = new Address("2BC", "Ravi Street", "Sambalpur", "Odisha", "India", 768220);

		coo2.setStaffMembers(list2);
		coo2.setAddress(addr2);

		List<OfficeStaffMember> list3 = new ArrayList<>();
		list3.add(new OfficeStaffMember(107, "Arun", "EMP"));
		list3.add(new OfficeStaffMember(108, "Tarun", "EMP"));
		list3.add(new OfficeStaffMember(109, "Arjun", "MGR"));
		Address addr3 = new Address("3BC", "Ravi Street", "Sambalpur", "Odisha", "India", 768220);

		coo3.setStaffMembers(list3);
		coo3.setAddress(addr3);

		List<CourierOfficeOutlet> listOffice = new ArrayList<>();
		listOffice.add(coo1);
		listOffice.add(coo2);
		listOffice.add(coo3);

		when(officeRepo.findAll()).thenReturn(listOffice);
		assertEquals(3, oos.getAllOfficesData().size());
	}

	@Test
	public void checkOfficeStatusTest() throws OutletClosedException {

		CourierOfficeOutlet coo = new CourierOfficeOutlet(200, LocalTime.of(10, 0), LocalTime.of(20, 0));
		List<OfficeStaffMember> list = new ArrayList<>();
		list.add(new OfficeStaffMember(101, "Arun", "EMP"));
		list.add(new OfficeStaffMember(102, "Tarun", "EMP"));
		list.add(new OfficeStaffMember(103, "Arjun", "MGR"));
		Address addr = new Address("1BC", "Ravi Street", "Sambalpur", "Odisha", "India", 768220);

		coo.setStaffMembers(list);
		coo.setAddress(addr);

		assertEquals(true, oos.isOfficeOpen(coo));
		assertEquals(false, oos.isOfficeClosed(coo));
	}
}

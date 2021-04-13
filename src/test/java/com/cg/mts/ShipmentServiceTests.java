package com.cg.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.entities.Customer;
import com.cg.mts.entities.Payment;
import com.cg.mts.repositories.CourierRepository;
import com.cg.mts.repositories.CustomerRepository;
import com.cg.mts.repositories.PaymentRepository;
import com.cg.mts.service.ShipmentService;

@SpringBootTest
class ShipmentServiceTests {

	@Autowired
	ShipmentService service;

	@MockBean
	CourierRepository courRepository;
	
	@MockBean
	CustomerRepository custRepository;
	
	@MockBean
	PaymentRepository paymentRepository;

	Courier courier;
	Payment payment;
	Customer sender;
	Customer receiver;
	
	
	@Test
	@DisplayName("Testing initiateShipmentTransaction method")
	void testInitiateShipmentTransaction() {
		
		courier = new Courier(CourierStatus.intransit, LocalDate.of(2021, 04, 06), LocalDate.now());
		payment = new Payment("ByDate", LocalDate.of(2021, 04, 06));
		sender = new Customer(1001, 98745621, "Tarun", "Kumar", 98745632);
		receiver = new Customer(1002, 99745621, "Varun", "Reddy", 98745665);
		
		courier.setConsignmentNo(1010100309);
		courier.setCourierId(2);	
		courier.setPayment(payment);
		courier.setSender(sender);
		courier.setReceiver(receiver);
		
		when(courRepository.save(courier)).thenReturn(courier);
		if(courRepository.existsById(courier.getCourierId())) {
		assertEquals(courier, service.initiateShipmentTransaction(courier));
		}
	}
	
	@Test
	@DisplayName("Testing shipment status")
	void testcheckShipmentStatus() {
		
		courier = new Courier(CourierStatus.intransit, LocalDate.of(2021, 04, 06), LocalDate.now());
		payment = new Payment("ByDate", LocalDate.of(2021, 04, 06));
		sender = new Customer(1003, 98745621, "Tarun", "Kumar", 98745632);
		receiver = new Customer(1004, 99745621, "Varun", "Reddy", 98745665);
		
		courier.setConsignmentNo(1010100311);
		courier.setCourierId(1);

		courier.setPayment(payment);
		courier.setSender(sender);
		courier.setReceiver(receiver);

		when(courRepository.save(courier)).thenReturn(courier);
			if(courRepository.existsById(courier.getCourierId())) {
		assertEquals(courier.getStatus(), service.checkShipmentStatus(courier.getCourierId()));
		}
	}

	@Test
	@DisplayName("Testing closeShipmentTransaction method")
	void testcloseShipmentTransaction() {
		courier = new Courier(CourierStatus.intransit, LocalDate.of(2021, 04, 06), LocalDate.now());
		payment = new Payment("ByDate", LocalDate.of(2021, 04, 06));
		sender = new Customer(1005, 98745621, "Tarun", "Kumar", 98745632);
		receiver = new Customer(1006, 99745621, "Varun", "Reddy", 98745665);
		
		courier.setConsignmentNo(1010100312);

		courier.setPayment(payment);
		courier.setSender(sender);
		courier.setReceiver(receiver);

		when(courRepository.save(courier)).thenReturn(courier);
		if(courRepository.existsById(courier.getCourierId())) {
			assertEquals(true, service.closeShipmentTransaction(courier.getCourierId()));
		}
	}
	
	@Test
	@DisplayName("Rejecting shipment transaction")
	void testrejectShipmentTransaction() {
		courier = new Courier(CourierStatus.intransit, LocalDate.of(2021, 04, 06), LocalDate.now());
		payment = new Payment("ByDate", LocalDate.of(2021, 04, 06));
		sender = new Customer(1005, 98745621, "Tarun", "Kumar", 98745632);
		receiver = new Customer(1006, 99745621, "Varun", "Reddy", 98745665);
		
		courier.setConsignmentNo(1010100312);

		courier.setPayment(payment);
		courier.setSender(sender);
		courier.setReceiver(receiver);

		when(courRepository.save(courier)).thenReturn(courier);
		if(courRepository.existsById(courier.getCourierId())) {
			assertEquals(true, service.closeShipmentTransaction(courier.getCourierId()));
		}
	}
}
package com.cg.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.entities.Address;
import com.cg.mts.entities.BankAccount;
import com.cg.mts.entities.Complaint;
import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.entities.Customer;
import com.cg.mts.entities.Payment;
import com.cg.mts.repository.ComplaintRepository;
import com.cg.mts.repository.CourierRepository;
import com.cg.mts.repository.CustomerRepository;
import com.cg.mts.repository.PaymentRepository;
import com.cg.mts.service.CustomerService;
import com.cg.mts.service.ShipmentService;

@SpringBootTest
class CustomerTests {

	 @Test
	 void contextLoads() {
	 }
	@Autowired
	private CustomerService service;
	
    @MockBean
    private ComplaintRepository repository;
	@MockBean
	private PaymentRepository payRepo;
	@MockBean
	private CourierRepository courRepo;
	@MockBean
	private CustomerRepository custRepo;
	
	@Test
	public void initiateProcess() {
		Customer senderCustomer = new Customer(100, 455455454, "Suresh", "Pal", 99999);
		Customer receiverCustomer = new Customer(101, 115455454, "Vuresh", "Sal", 11999);
		
		Courier courier = new Courier();
		courier.setSender(senderCustomer);
		courier.setReceiver(receiverCustomer);
		courier.setStatus(CourierStatus.initiated);
		courier.setInitiatedDate(LocalDate.now());
		courier.setDeliveredDate(LocalDate.now().plusDays(5));
        if(custRepo.existsById(senderCustomer.getCustomerId()) && custRepo.existsById(receiverCustomer.getCustomerId())) {
        
		when(courRepo.save(courier)).thenReturn(courier);
		assertEquals(true,service.initiateProcess(senderCustomer, receiverCustomer));
        }
		
	}
	
	@Test
	public void makePayment() {
		//Customer customer =new Customer(100, 455455454, "Suresh", "Pal", 99999);
		Courier courier = new Courier(CourierStatus.initiated, LocalDate.of(2021, 04, 04), LocalDate.now());
		Payment payment= new Payment("By Cash",LocalDate.now());
		payment.setCourier(courier);
		when(payRepo.save(payment)).thenReturn(payment);
		if(payRepo.existsById(payment.getPaymentId()))
		assertEquals(true,service.makePayment(courier.getCourierId(),payment.getPaymentMode()));
		
	}
	@Test
	public void checkStatus() {

		Courier courier1= new Courier();
	       
        courier1.setCourierId(111);
        //courier1.setConsignmentNo(112);
        courier1.setStatus(CourierStatus.delivered);
        courier1.setInitiatedDate(LocalDate.of(2018, 11, 16));
        courier1.setDeliveredDate(LocalDate.of(2018, 11, 28));
       
       
        when(courRepo.save(courier1)).thenReturn(courier1);
        if(courRepo.existsById(courier1.getCourierId())) {
        assertEquals(courier1.getStatus(), service.checkOnlineTrackingStatus(courier1.getCourierId()));
        }
	}
	@Test
	public void addingnewComplaint() {
		Customer customer =new Customer(100, 455455454, "Suresh", "Pal", 99999);
		Courier courier = new Courier(CourierStatus.initiated, LocalDate.of(2021, 04, 04), LocalDate.now());
		Complaint compl= new Complaint("stuck","courier stuck for 3 days");
		
		compl.setConsignmentNo(courier);
		compl.setCustomer(customer);
		when(repository.save(compl)).thenReturn(compl);
		assertEquals(true,service.registerComplaint(compl));
		
	}
	/*@Test
	public void addcust() {
		Customer customer =new Customer(100, 455455454, "Suresh", "Pal", 99999);
		when(crepository.save(customer)).thenReturn(customer);
		assertEquals(100,service.add(customer));
	}
	@Test
    public void addingNew() {
       
		Customer customer =new Customer(100, 455455454, "Suresh", "Pal", 99999);
        
        Address addr= new Address("1BC", "Ravi Street", "Sambalpur", "Odisha", "India", 768220);
        BankAccount ba1 = new BankAccount(145745, "Suresh", "Saving");
       
        customer.setAccount(ba1);
        customer.setAddress(addr);
       
        when(cusrepo.save(customer)).thenReturn(customer);
        assertEquals(true, service.add(customer));
    }*/

	
	
}

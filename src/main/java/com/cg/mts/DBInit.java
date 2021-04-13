package com.cg.mts;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cg.mts.entities.Address;
import com.cg.mts.entities.BankAccount;
import com.cg.mts.entities.Complaint;
import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.entities.Customer;
import com.cg.mts.entities.Manager;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.entities.Payment;
import com.cg.mts.repository.AddressRepository;
import com.cg.mts.repository.BankAccountRepository;
import com.cg.mts.repository.ComplaintRepository;
import com.cg.mts.repository.CourierOfficeOutletRepository;
import com.cg.mts.repository.CourierRepository;
import com.cg.mts.repository.CustomerRepository;
import com.cg.mts.repository.PaymentRepository;
import com.cg.mts.repository.StaffMemberRepository;

@Component
public class DBInit implements CommandLineRunner {
	@Autowired
	CustomerRepository custrepo;
	@Autowired
	ComplaintRepository complrep;
	@Autowired
	BankAccountRepository bankrepo;
	@Autowired
	CourierRepository courrepo;
	@Autowired
	PaymentRepository payrepo;
	@Autowired
	CourierOfficeOutletRepository cofrepo;
	@Autowired
	StaffMemberRepository staffrepo;
	
	@Autowired
	AddressRepository addressRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Customer customer1 = new Customer(100, 455455454, "Suresh", "Pal", 99999);
        Customer customer2 = new Customer(101, 115455454, "Vuresh", "Sal", 11999);
        Customer customer3 = new Customer(102, 775455454, "Luresh", "Tal", 34999);
        
        BankAccount ba1 = new BankAccount(145745, "Suresh", "Saving");
        BankAccount ba2 = new BankAccount(115745, "Vuresh", "Current");
        BankAccount ba3 = new BankAccount(175745, "Luresh", "FixDEposit");
        
        Courier cc = new Courier(CourierStatus.initiated, LocalDate.of(2021, 04, 04), LocalDate.now());

 

        Payment payment = new Payment("Card", LocalDate.of(2001, 01, 29));
        Complaint complaint = new Complaint("Courier stuck", "I didn't get update for my courier");

 

        CourierOfficeOutlet cooff = new CourierOfficeOutlet(00002, LocalTime.of(10, 00), LocalTime.of(05, 00));
        cofrepo.save(cooff);
        Address address = new Address("XZ1", "NYC Rd", "NYC", "NYCM", "USA", 45287);
        addressRepo.save(address);

        cc.setSender(customer1);
        cc.setReceiver(customer2);
        complaint.setConsignmentNo(cc);
        complaint.setCustomer(customer1);
        complaint.setCustomer(customer2);
        complaint.setCustomer(customer3);
        payment.setCourier(cc);
        
        custrepo.save(customer1);
        custrepo.save(customer2);
        custrepo.save(customer3);
        
        courrepo.save(cc);
        
        bankrepo.save(ba1);
        bankrepo.save(ba2);
        bankrepo.save(ba3);
        
        payrepo.save(payment);
        
        complrep.save(complaint);
		
		


	}

}

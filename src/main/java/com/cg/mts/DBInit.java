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

		Manager manager = new Manager(222, "Hitesh");
		Address address = new Address("XZ1", "NYC Rd", "NYC", "NYCM", "USA", 45287);

		OfficeStaffMember sm = new OfficeStaffMember(119, "Turesh", "EMP", address, cooff, manager);
		cofrepo.save(cooff);
		staffrepo.save(sm);

		// custrepo.save(new Customer(100,455455454,"Suresh","Pal",99999));
		// custrepo.save(new Customer(200,115455454,"Kuresh","Sal",12999));
		// custrepo.save(new Customer(300,775455454,"Vuresh","Hal",45999));
		// custrepo.save(new Customer(400,955455454,"Nuresh","Tal",74999));
		// custrepo.save(new Customer(500,375455454,"Hiresh","Kal",11999));
		// custrepo.save(new Customer(600,225455454,"Puresh","Nal",56999));
		// courrepo.save(new Courier(CourierStatus.delivered, LocalDate.of(2021, 04,
		// 04), LocalDate.now()));
		// cc.setStatus(CourierStatus.delivered);
		// courrepo.save(new Courier(CourierStatus.delivered, LocalDate.of(2021, 04,05),
		// LocalDate.now()));
		// courrepo.save(new Courier(CourierStatus.intransit, LocalDate.of(2021, 04,
		// 06), LocalDate.now()));
		// courrepo.save(new Courier(CourierStatus.rejected, LocalDate.of(2021, 04, 07),
		// LocalDate.now()));
		// List<Complaint> complaint= new ArrayList<>();
		// complaint.add(new Complaint("Courier stuck","I didn't get update for my
		// --------------------
		// Manager manager = new Manager(116,"Arun");
		// Address address = new Address("12c","MG
		// Road","Motihari","Bihar","India",845401);
		// CourierOfficeOutlet office = new CourierOfficeOutlet(112,LocalTime.of(10,
		// 00),LocalTime.of(05, 00));
		// staffrepo.save(new
		// OfficeStaffMember(111,"Ashish","EMP",address,office,manager));
		// staffrepo.save(new
		// OfficeStaffMember(112,"Verma","EMP",address,office,manager));

		// ---------------
		// payrepo.save(new Payment("Card", LocalDate.of(2001, 01, 29)));
		// payrepo.save(new Payment("Cash", LocalDate.of(2002, 12, 18)));
		// ---------------

		// courier"));
		// cc.getConsignmentNo();
		//ba1.setCustomer(customer1);
		//customer1.setAccount(ba1);
		//customer2.setAccount(ba2);
		//customer3.setAccount(ba3);
		// customer.setComplaint(complaint);

		 cc.setSender(customer1);//
		 cc.setReceiver(customer2);//
		// complaint.setConsignmentNo(cc);
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

		// payrepo.save(new Payment();
		// payrepo.save(new Payment("Cash", LocalDate.of(2002, 12, 18)));
		// complrep.save(new Complaint("Courier stuck","I didn't get update for my
		// courier"));

		// bankrepo.save(new BankAccount(1457893,"Suresh","Saving"));

		// List<Employee> list1= repo.findByName("Huresh");
		// List<Employee> list1= repo.getBySalaryRange(1000f , 2500f);
		// System.out.println(list1);
	}

}

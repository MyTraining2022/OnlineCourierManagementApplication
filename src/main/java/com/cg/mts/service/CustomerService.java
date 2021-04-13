package com.cg.mts.service;

import java.util.ArrayList;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cg.mts.dao.ComplaintDao;
import com.cg.mts.dao.CourierDao;
import com.cg.mts.dao.CustomerDao;
import com.cg.mts.dao.PaymentDao;
import com.cg.mts.entities.Complaint;
import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.entities.Customer;
import com.cg.mts.entities.Payment;
import com.cg.mts.exceptions.CourierIdExistsException;
import com.cg.mts.exceptions.CourierNotFoundException;
import com.cg.mts.exceptions.CustomerNotFoundException;
import com.cg.mts.repository.CourierRepository;
import com.cg.mts.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	@Qualifier("jpaDao")
	CustomerDao dao;
	@Autowired
	PaymentDao pdao;
	@Autowired
	ComplaintDao cdao;
	@Autowired
	CourierDao codao;
	@Autowired
	CustomerRepository cusrepo;
	@Autowired
	CourierRepository courRepo;


	@Override
	public boolean initiateProcess(Customer senderCustomer, Customer recieverCustomer) throws CourierIdExistsException {
		if (cusrepo.existsById(senderCustomer.getCustomerId())
				&& cusrepo.existsById(recieverCustomer.getCustomerId())) {

			Courier courier = new Courier();
			courier.setSender(senderCustomer);
			courier.setStatus(CourierStatus.initiated);
			courier.setInitiatedDate(LocalDate.now());
			courier.setDeliveredDate(LocalDate.now().plusDays(5));
			courier.setReceiver(recieverCustomer);
			codao.addCourier(courier);
			return true;

		} else {
			//throw new CustomerNotFoundException("senderCustomer with id" + senderCustomer.getCustomerId() + "not exist",
					//"or senderReciever with id+" + recieverCustomer.getCustomerId() + "not exist");
			cusrepo.save(senderCustomer);
			cusrepo.save(recieverCustomer);
			Courier courier = new Courier();
			courier.setSender(senderCustomer);
			courier.setStatus(CourierStatus.initiated);
			courier.setInitiatedDate(LocalDate.now());
			courier.setDeliveredDate(LocalDate.now().plusDays(5));
			courier.setReceiver(recieverCustomer);
			codao.addCourier(courier);
			return true;
			
		}

	}
	/*@Override
	public void initiateProcess() {
		Customer customer1 = new Customer(100, 455455454, "Suresh", "Pal", 99999);
		Customer customer2 = new Customer(101, 115455454, "Vuresh", "Sal", 11999);
		
		Courier courier = new Courier();
		courier.setSender(customer1);
		courier.setStatus(CourierStatus.initiated);
		courier.setInitiatedDate(LocalDate.now());
		courier.setDeliveredDate(LocalDate.now().plusDays(5));
		courier.setReceiver(customer2);
		//dao.save(customer1);
		//dao.save(customer2);
		codao.addCourier(courier);
		
	}*/
	

	@Override
	public boolean makePayment(int id, String mode) {
		if (mode == "By Cash") {
			return pdao.addPaymentByCash(id);

		} else {
			return pdao.addPaymentByCard(id);
		}

	}

	@Override
	public CourierStatus checkOnlineTrackingStatus(int courierId) throws CourierNotFoundException { // I hv chnged from
																									// consignmentno to
																									// courierI
		Optional<Courier> courier = courRepo.findById(courierId);
        if(courier.isPresent()) {
        return  courier.get().getStatus();
        }else {
        throw new CourierNotFoundException("CourierId is not in database"+courierId);
    }
    
	}

	@Override
	public boolean registerComplaint(Complaint complaint) {
		cdao.addNewComplaint(complaint);
		return true;

	}

	@Override
	public boolean add(Customer e) {

		dao.save(e);
		return true;

	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return dao.getAllCustomers();
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public Customer getCustomer(int id) {
		return dao.getCustomer(id);
	}

	@Override
	public boolean update(Customer e) {

		return dao.update(e);
	}

}
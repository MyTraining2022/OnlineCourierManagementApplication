package com.cg.mts.service;

import java.util.ArrayList;

import java.time.LocalDate;
import java.util.List;
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
	

	@Override
	public void initiateProcess(Customer senderCustomer, Customer recieverCustomer) throws CourierIdExistsException {
		if(cusrepo.existsById(senderCustomer.getCustomerId()) && cusrepo.existsById(recieverCustomer.getCustomerId()))	{
			
			Courier courier = new Courier();
			courier.setSender(senderCustomer);
			courier.setStatus(CourierStatus.initiated);
			courier.setInitiatedDate(LocalDate.now());
			courier.setDeliveredDate(LocalDate.now().plusDays(5));
			courier.setReceiver(recieverCustomer);
			codao.addCourier(courier);
			
		}
		else {
			throw new CustomerNotFoundException("senderCustomer with id"+ senderCustomer.getCustomerId()+"not exist","or senderReciever with id+"+recieverCustomer.getCustomerId()+"not exist");
		}

	}

	@Override
	public void makePayment(int id) {
		// pdao.addPayment(null);
		Payment pay = new Payment();
	
		pdao.addPayment(pay); // pay.getPaymentId()

	}

	@Override
	public CourierStatus checkOnlineTrackingStatus(int courierId) throws CourierNotFoundException { // I hv chnged from
																									// consignmentno to
																									// courierId
		Courier courier = codao.getCourier(courierId);
		return courier.getStatus();
	}

	@Override
	public void registerComplaint(Complaint complaint) {
		cdao.addNewComplaint(complaint);

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
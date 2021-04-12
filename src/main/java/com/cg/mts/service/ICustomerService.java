package com.cg.mts.service;

import java.util.List;

import com.cg.mts.entities.Complaint;
import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.entities.Customer;
import com.cg.mts.exceptions.CourierIdExistsException;
import com.cg.mts.exceptions.CourierNotFoundException;

public interface ICustomerService {

	public void initiateProcess(Customer senderCustomer, Customer recieverCustomer) throws CourierIdExistsException;
	public void makePayment(int id);
	public CourierStatus checkOnlineTrackingStatus(int courierId) throws CourierNotFoundException;
	public void registerComplaint(Complaint complaint);
	
	boolean add(Customer e);
	List<Customer> getAll();
	boolean delete(int id);
	Customer getCustomer(int id);
	boolean update(Customer e);
	
	
	
	
}

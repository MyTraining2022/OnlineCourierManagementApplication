package com.cg.mts.service;

import java.util.List;

import com.cg.mts.entities.Complaint;
import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.entities.Customer;
import com.cg.mts.exceptions.CourierIdExistsException;
import com.cg.mts.exceptions.CourierNotFoundException;

public interface ICustomerService {

	public boolean initiateProcess(Customer senderCustomer, Customer recieverCustomer) throws CourierIdExistsException;

	public boolean makePayment(int id, String mode);

	public CourierStatus checkOnlineTrackingStatus(int courierId) throws CourierNotFoundException;

	public boolean registerComplaint(Complaint complaint);

	boolean add(Customer e);

	List<Customer> getAll();

	boolean delete(int id);

	Customer getCustomer(int id);

	boolean update(Customer e);

	//void initiateProcess();

}

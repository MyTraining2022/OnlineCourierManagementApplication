package com.cg.mts.dao;

import java.util.List;

import com.cg.mts.entities.Customer;
import com.cg.mts.exceptions.DuplicateCustomerException;


public interface ICustomerDao {
	void save(Customer e) throws DuplicateCustomerException;
	boolean update(Customer e);
	boolean delete(int customerId);
	Customer getCustomer(int customerId);
	List<Customer> getAllCustomers();
	

}

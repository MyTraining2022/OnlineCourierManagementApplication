package com.cg.mts.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mts.entities.Customer;
import com.cg.mts.exceptions.DuplicateCustomerException;
import com.cg.mts.repository.CustomerRepository;

@Component("jpaDao")
public class CustomerDao implements ICustomerDao {
	@Autowired
	CustomerRepository repository;

	public CustomerDao() {

	}
	
	@Override
	public void save(Customer e){

			repository.save(e);
		
			throw new DuplicateCustomerException("Customer you supplied is duplicate");
		
	}

	@Override
	public boolean update(Customer e) {

		if (repository.findById(e.getCustomerId()).isPresent()) {
			repository.save(e);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int customerId) {

		Optional<Customer> e = repository.findById(customerId);
		if (e.isPresent()) {
			repository.deleteById(customerId);
			return true;
		}
		return false;
	}

	@Override
	public Customer getCustomer(int customerId) {
		Optional<Customer> e = repository.findById(customerId);
		if(e.isPresent()) {
			return e.get();
		}
		else {
			return null;
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> list = (List<Customer>) repository.findAll();
		
		return list;
	}

	
	
	

	/*@Override
	public void save(Customer e) throws DuplicateCustomerException {
		if (repository.existsById(e.getCustomerId()))
			throw new DuplicateCustomerException("Customer you supplied is duplicate");
		repository.save(e);
	}

	@Override
	public boolean update(Customer e) {
		if (repository.findById(e.getCustomerId()).isPresent()) {
			repository.save(e);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int customerId) {
		if (repository.existsById(customerId)) {
			repository.deleteById(customerId);
			return true;
		}
		return false;

	}

	@Override
	public Customer getCustomer(int customerId) {
		if (repository.existsById(customerId)) {
			Optional<Customer> cust = repository.findById(customerId);
			return cust.get();
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list = repository.findAll();
		return list;
	}*/

}

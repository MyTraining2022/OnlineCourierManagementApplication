package com.cg.mts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.CourierStatus;
import com.cg.mts.entities.Customer;
import com.cg.mts.exceptions.CustomerNotFoundException;
import com.cg.mts.exceptions.EmptyDataException;
import com.cg.mts.service.CustomerService;




@RestController
@RequestMapping("customers")

public class CustomerController {
	@Autowired
	CustomerService service;

	@GetMapping(value = "{eid}")
	public ResponseEntity<?> getCustomer(@PathVariable("eid") int customerId) {
		Customer e = service.getCustomer(customerId);
		if (e == null)
			throw new CustomerNotFoundException("Request", "Customer with customer id:" + customerId + " not found");

		return new ResponseEntity<Customer>(e, HttpStatus.OK);

	}

	@GetMapping
	public List<Customer> getAllCustomer() {
		List<Customer> list = service.getAll();
		if (list.size() == 0)
			throw new EmptyDataException("No customer in data base");
		return list;
	}

	@PostMapping
	public String saveCustomer(Customer e) {
		service.add(e);
		return "Customer Data saved successfully";

	}

	@PutMapping
	public String updateCustomer(@Valid @RequestBody Customer e) {
		if (service.update(e)) {
			return "Customer Data successfully updated";
		} else {
			throw new CustomerNotFoundException("update",
					"Customer with customer id:" + e.getCustomerId() + " not found");
		}
	}

	@DeleteMapping("{eid}")
	public String deleteCustomer(@PathVariable("eid") int customerId) {
		if (service.delete(customerId)) {
			return "Customer data deleted successfully";

		} else {
			return "Customer to delete not found";
		}
	}
	@GetMapping(value="/filterBy/id_type/CourierStatus/{cid}")
    public CourierStatus getCourierStatus(@PathVariable(name= "cid")int courierId) {
       
        return service.checkOnlineTrackingStatus(courierId);
         
    }
}

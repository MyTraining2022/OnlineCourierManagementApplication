package com.cg.mts.controller;

import java.util.List;

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

import com.cg.mts.entities.Courier;
import com.cg.mts.exceptions.CourierNotFoundException;
import com.cg.mts.service.IShipmentService;

@RestController
@RequestMapping("shipments")
public class ShipmentController {
	
	@Autowired
	IShipmentService service;
	
	@GetMapping("{sid}")
	public ResponseEntity<Courier> getShipment(@PathVariable("sid") int courierId) {
		Courier courier = service.getShipment(courierId);
		if(courier == null) {
			throw new CourierNotFoundException("courier with id " + courierId + " not found");
		}
		return new ResponseEntity<Courier>(courier, HttpStatus.OK);
	}
	
	@GetMapping
	public List<Courier> getAllShipments() {
		List<Courier> list = service.getAllShipments();
		if(list.isEmpty()) {
			throw new CourierNotFoundException("No couriers in the database");
		}
		return list;
	}
	
	@PostMapping
	public String addShipment(@RequestBody Courier courier) {
		service.initiateShipmentTransaction(courier);
		return "Courier successfully added";
	}
	
	@DeleteMapping("{sid}")
	public String deleteShipment(@PathVariable("sid") int courierId) {
		if(service.deleteShipment(courierId)) {
			return "Delete successfull";
		}
		else {
			throw new CourierNotFoundException("Courier with id " + courierId + " not found");
		}
	}
	
	@PutMapping
	public String updateShipment(@RequestBody Courier courier) {
		if(service.updateShipment(courier))
			return "Successfully updated";
		else
			throw new CourierNotFoundException("Courier with id " + courier.getCourierId() + " not found");
	}
	
}

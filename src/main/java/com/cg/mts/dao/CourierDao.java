package com.cg.mts.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.exceptions.CourierIdExistsException;
import com.cg.mts.exceptions.CourierNotFoundException;
import com.cg.mts.repository.CourierRepository;

@Component
public class CourierDao implements ICourierDao{

	@Autowired
	CourierRepository courRepository;

	public List<Courier> getAllCouriers() {
			List<Courier> cour = courRepository.findAll();
			return cour;
	}

	public Courier getCourier(int courierId) throws CourierNotFoundException {
		if (!(courRepository.existsById(courierId))) {
			throw new CourierNotFoundException("Courier with Id " + courierId + " not found");
		} 
		else {
			Optional<Courier> courier1 = courRepository.findById(courierId);
			return courier1.get();
		}
	}

	public void addCourier(Courier courier) throws CourierIdExistsException{
		if(courRepository.existsById(courier.getCourierId())) {
			courRepository.save(courier);
		}
		throw new CourierIdExistsException("Courier with id" + courier.getCourierId() + " already exists");
	}

	public boolean deleteCourier(int courierId) {
		if(courRepository.existsById(courierId)) {
			courRepository.deleteById(courierId);
			return true;
		}
		return false;
	}
	
	public boolean updateCourier(Courier courier) {
		if(courRepository.existsById(courier.getCourierId())) {
			courRepository.save(courier);
			return true;
		}
		return false;
	}

	@Override
	public CourierStatus getCourierStatus(Courier courier) throws CourierNotFoundException{
		if(courRepository.existsById(courier.getCourierId())) {
			return courier.getStatus();
		}
		throw new CourierNotFoundException("Courier does not exists");
	}
}
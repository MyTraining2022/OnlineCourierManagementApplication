package com.cg.mts.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.exception.CourierNotFoundException;
import com.cg.mts.repositories.CourierRepository;

@Component
public class CourierDao implements ICourierDao {

	@Autowired
	CourierRepository courRepository;

	@Override
	public List<Courier> getAllCouriers() {
		Iterable<Courier> c = courRepository.findAll();
		List<Courier> couriers = new ArrayList<>();
		for(Courier cour : c) {
			couriers.add(cour);
		}
		return couriers;
	}

	@Override
	public Courier addCourier(Courier courier) {
		if(!(courRepository.existsById(courier.getCourierId()))) {
				return courRepository.save(courier);	
		}
			return null;
	}
	
	@Override
	public Courier getCourier(int courierId) {
		 if (!(courRepository.existsById(courierId))) {
		 throw new CourierNotFoundException("Courier with Id " + courierId + " not found");
		 } else {
				Optional<Courier> courier1 = courRepository.findById(courierId);
				if(courier1.isPresent()) {
					return courier1.get();
				}
				else {
					throw new IllegalArgumentException("No value found");
				}
		 }
	}
	

	@Override
	public boolean deleteCourier(int courierId) {
		if (courRepository.existsById(courierId)) {
			courRepository.deleteById(courierId);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCourier(Courier courier) {
		if (courRepository.existsById(courier.getCourierId())) {
			courRepository.save(courier);
			return true;
		}
		return false;
	}

	@Override
	public CourierStatus getCourierStatus(int courierId) {
		Optional<Courier> courier1 = courRepository.findById(courierId);
		return courier1.get().getStatus();
	}

	@Override
	public boolean updateCourierStatus(int courierId) {
		if(courRepository.existsById(courierId)) {
			Optional<Courier> courier1 = courRepository.findById(courierId);
			courier1.get().setStatus(CourierStatus.delivered);
			return true;
		}
		return false;
	}
}

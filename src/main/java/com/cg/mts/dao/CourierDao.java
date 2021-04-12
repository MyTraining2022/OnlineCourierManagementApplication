package com.cg.mts.dao;

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
		List<Courier> cour = courRepository.findAll();
		return cour;
	}

	@Override
	public void addCourier(Courier courier) {
		if(!(courRepository.existsById(courier.getCourierId())))
				courRepository.save(courier);	
	}
	
	@Override
	public Courier getCourier(int courierId) throws CourierNotFoundException  {
		 if (!(courRepository.existsById(courierId))) {
		 throw new CourierNotFoundException("Courier with Id " + courierId + " not found");
		 } else {
				Optional<Courier> courier1 = courRepository.findById(courierId);
				return courier1.get();
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
	public CourierStatus getCourierStatus(Courier courier) {
		Optional<Courier> courier1 = courRepository.findById(courier.getCourierId());
		return courier1.get().getStatus();
	}

	@Override
	public CourierStatus updateCourierStatus(Courier courier) {
		Optional<Courier> courier1 = courRepository.findById(courier.getCourierId());
		courier1.get().setStatus(CourierStatus.delivered);
		return courier1.get().getStatus();
	}
}

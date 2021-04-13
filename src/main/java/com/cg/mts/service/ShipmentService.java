package com.cg.mts.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.dao.ICourierDao;
import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;

@Service
public class ShipmentService implements IShipmentService {

	@Autowired
	ICourierDao dao;
	
	@Override
	public Courier initiateShipmentTransaction(Courier courier) {
			dao.addCourier(courier);
			dao.getCourier(courier.getCourierId()).setStatus(CourierStatus.initiated);
			dao.getCourier(courier.getCourierId()).setInitiatedDate(LocalDate.now());
			return dao.addCourier(courier);
		}
	
	@Override
	public CourierStatus checkShipmentStatus(int courierId) {
		return dao.getCourierStatus(courierId);
	}

	@Override
	public boolean closeShipmentTransaction(int courierId) {
		if(dao.updateCourierStatus(courierId))
			return true;
		return false;
	}

	@Override
	public boolean rejectShipmentTransaction(int courierId) {
		dao.getCourier(courierId).setStatus(CourierStatus.rejected);
		return dao.deleteCourier(courierId); 
	}

	@Override
	public Courier getShipment(int courierId) {
		return dao.getCourier(courierId);
	}

	@Override
	public List<Courier> getAllShipments() {
		if(dao.getAllCouriers() == null)
			return null;
		return dao.getAllCouriers();
	}

	@Override
	public boolean deleteShipment(int courierId) {
		if(dao.deleteCourier(courierId))
			return true;
		return false;
	}

	@Override
	public boolean updateShipment(Courier courier) {
		dao.updateCourier(courier);
			return true;
	}

}

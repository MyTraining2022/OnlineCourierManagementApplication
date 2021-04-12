package com.cg.mts.service;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.dao.ICourierDao;
import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.exception.CourierNotFoundException;

@Service
public class ShipmentService implements IShipmentService {

	@Autowired
	ICourierDao dao;
	
	@Override
	public void initiateShipmentTransaction(Courier courier) throws CourierNotFoundException /*throws CourierNotFoundException*/ {
		dao.addCourier(courier);
			dao.getCourier(courier.getCourierId()).setStatus(CourierStatus.initiated);
			dao.getCourier(courier.getCourierId()).setInitiatedDate(LocalDate.now());
		}
	
	@Override
	public CourierStatus checkShipmentStatus(Courier courier) {// throws CourierNotFoundException{
		return dao.getCourierStatus(courier);
	}

	@Override
	public CourierStatus closeShipmentTransaction(Courier courier) {//throws CourierNotFoundException {
		return dao.updateCourierStatus(courier);
	}

	@Override
	public void rejectShipmentTransaction(Courier courier) throws CourierNotFoundException{//throws CourierNotFoundException {
		dao.getCourier(courier.getCourierId()).setStatus(CourierStatus.rejected);
		dao.deleteCourier(courier.getCourierId());
	}

}

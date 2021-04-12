package com.cg.mts.service;

import java.time.LocalDate;

import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;

public class ShipmentService implements IShipmentService {

	@Override
	public void initiateShipmentTransaction(Courier courier) {
		courier.setInitiatedDate(LocalDate.now());
		courier.setStatus(CourierStatus.initiated);
	}

	@Override
	public CourierStatus checkShipmentStatus(Courier courier) {
		return courier.getStatus();
	}

	@Override
	public void closeShipmentTransaction(Courier courier) {
		courier.setStatus(CourierStatus.delivered);
		courier.setDeliveredDate(LocalDate.now());
	}

	@Override
	public void rejectShipmentTransaction(Courier courier) {
		courier.setStatus(CourierStatus.rejected);
	}

}

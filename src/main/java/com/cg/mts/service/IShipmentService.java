package com.cg.mts.service;

import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.exception.CourierNotFoundException;

public interface IShipmentService {

	public void initiateShipmentTransaction(Courier courier) throws CourierNotFoundException;

	public CourierStatus checkShipmentStatus(Courier courier); 

	public CourierStatus closeShipmentTransaction(Courier courier);

	public void rejectShipmentTransaction(Courier courier) throws CourierNotFoundException;

}

package com.cg.mts.service;

import java.util.List;

import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.exception.CourierNotFoundException;

public interface IShipmentService {

	public Courier initiateShipmentTransaction(Courier courier);

	public CourierStatus checkShipmentStatus(int courierId); 

	public boolean closeShipmentTransaction(int courierId);

	public boolean rejectShipmentTransaction(int courierId);
	
	Courier getShipment(int courierId);
	
	List<Courier> getAllShipments();
	
	boolean deleteShipment(int courierId);
	
	boolean updateShipment(Courier courier);

}

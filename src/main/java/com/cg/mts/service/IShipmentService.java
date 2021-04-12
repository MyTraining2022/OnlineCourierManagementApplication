package com.cg.mts.service;

import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;

public interface IShipmentService {
	
	public void initiateShipmentTransaction(Courier courier);
	public CourierStatus checkShipmentStatus(Courier courier);
	public void closeShipmentTransaction(Courier courier);
	public void rejectShipmentTransaction(Courier courier);
	

}

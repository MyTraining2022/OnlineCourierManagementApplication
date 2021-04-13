package com.cg.mts.dao;

import java.util.List;

import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.exceptions.CourierNotFoundException;

public interface ICourierDao {

	List<Courier> getAllCouriers();
	
	Courier getCourier(int courierId);
	
	Courier addCourier(Courier courier);
	
	boolean deleteCourier(int courierId);
	
	boolean updateCourier(Courier courier);
	
	CourierStatus getCourierStatus(int courierId);
	
	boolean updateCourierStatus(int courierId);
}

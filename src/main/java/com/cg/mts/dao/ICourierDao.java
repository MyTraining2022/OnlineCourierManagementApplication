package com.cg.mts.dao;

import java.util.List;

import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.exception.CourierNotFoundException;

public interface ICourierDao {

	List<Courier> getAllCouriers();
	
	public Courier getCourier(int courierId) throws CourierNotFoundException;
	
	public void addCourier(Courier courier);
	
	boolean deleteCourier(int courierId);
	
	boolean updateCourier(Courier courier);
	
	CourierStatus getCourierStatus(Courier courier);
	
	CourierStatus updateCourierStatus(Courier courier);
}

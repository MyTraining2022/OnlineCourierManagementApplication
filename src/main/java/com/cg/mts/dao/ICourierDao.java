package com.cg.mts.dao;

import java.util.List;

import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;
import com.cg.mts.exceptions.CourierIdExistsException;
import com.cg.mts.exceptions.CourierNotFoundException;

public interface ICourierDao {
	public List<Courier> getAllCouriers();
	public Courier getCourier(int courierId) throws CourierNotFoundException;
	public void addCourier(Courier courier) throws CourierIdExistsException;
	CourierStatus getCourierStatus(Courier courier) throws CourierNotFoundException;
	

}

package com.trg.trainner.boot.service;

import java.util.List;

import com.trg.trainner.boot.dto.Trainee;



public interface ServiceDao {

	Trainee getTrainee(int id);
	List<Trainee> getAll();
	List<Trainee> getByNames(String name);
	
	boolean add(Trainee t);
	boolean delete(int id);
	boolean update(Trainee t);
}

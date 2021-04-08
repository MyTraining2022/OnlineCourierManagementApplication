package com.trg.trainner.boot.dao;

import java.util.List;

import com.trg.trainner.boot.dto.Trainee;
import com.trg.trainner.boot.exception.DuplicateTraineeException;

public interface TraineeDao {
	
	void save(Trainee t) throws DuplicateTraineeException;
	
	boolean update(Trainee t);
	
	boolean delete(int id);
	
	Trainee getTrainee(int id);
	
	List<Trainee> getAllTrainee();
	//List<Trainee> getByNames(String name);

}

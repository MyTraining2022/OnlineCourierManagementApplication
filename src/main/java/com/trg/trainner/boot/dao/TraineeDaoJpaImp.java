package com.trg.trainner.boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.trg.trainner.boot.dto.Trainee;
import com.trg.trainner.boot.exception.DuplicateTraineeException;
import com.trg.trainner.boot.repo.TraineeReposi;

@Component
public class TraineeDaoJpaImp implements TraineeDao {

	@Autowired
	TraineeReposi reposi;
	
	
	@Override
	public void save(Trainee t) throws DuplicateTraineeException {
		if(reposi.existsById(t.getTraineeId()))
			throw new DuplicateTraineeException("Employee wit id "+t.getTraineeId()+" allready in data");
		else
			reposi.save(t);
	}

	@Override
	public boolean update(Trainee t) {
		if(reposi.existsById(t.getTraineeId())) {
			reposi.save(t);
		return true; 
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		if(reposi.existsById(id)){
			reposi.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Trainee getTrainee(int id) {
		Optional<Trainee> ts = reposi.findById(id);
		if(ts.isPresent()) {
			return ts.get();
		}
		return null;
	}

	@Override
	public List<Trainee> getAllTrainee() {
		 List<Trainee> ls = (List<Trainee>) reposi.findAll();
		return ls;
	}
	
	/*public List<Trainee> getByName(String name){
		List<Trainee> ls = reposi.findByName(name);
		return ls;
	}*/

	

}

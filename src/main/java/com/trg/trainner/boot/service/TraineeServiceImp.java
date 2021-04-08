package com.trg.trainner.boot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trg.trainner.boot.dao.TraineeDao;
import com.trg.trainner.boot.dto.Trainee;
import com.trg.trainner.boot.exception.DuplicateTraineeException;
import com.trg.trainner.boot.repo.TraineeReposi;

@Service
public class TraineeServiceImp implements ServiceDao{
	
	@Autowired
	TraineeDao dao;
	
	@Autowired
	TraineeReposi traps;

	@Override
	public Trainee getTrainee(int id) {
		return dao.getTrainee(id);
	}

	@Override
	public List<Trainee> getAll() {
		return dao.getAllTrainee();
		//return null;
	}
	
	@Override
	public List<Trainee> getByNames(String name) {
		//List<Trainee> ls = dao.getAllTrainee();
		
		List<Trainee> ls1 = traps.findByName(name);
		return ls1;
		
		/*if(ls==null) {
			return null;
		}
		return ls.stream().filter(e->e.getName().startsWith(name)).collect(Collectors.toList());*/
		
	}

	@Override
	public boolean add(Trainee t) {
		try {
			dao.save(t);
			return true;
		}catch(DuplicateTraineeException tx) {
			return false; 
			
		}
		
	}

	@Override
	public boolean delete(int id) {
		return dao.delete(id);
	}

	@Override
	public boolean update(Trainee t) {
		return dao.update(t);
	}



}

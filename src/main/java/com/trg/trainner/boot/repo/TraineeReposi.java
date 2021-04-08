package com.trg.trainner.boot.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.trg.trainner.boot.dto.Trainee;

public interface TraineeReposi extends CrudRepository<Trainee,Integer> {
	
	
	
	List<Trainee> findByName(String name);
	List<Trainee> findByDomain(String domain);

}

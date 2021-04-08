package com.trg.trainner.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.trg.trainner.boot.dto.Trainee;
import com.trg.trainner.boot.service.ServiceDao;

@RestController
@RequestMapping("trainees")
public class TraineeController {
	
	@Autowired
	ServiceDao sd;
	
	@GetMapping
	public List<Trainee> getAllTrainee(){
		return sd.getAll();
		
	}
	
	@GetMapping("Byid/{id}")
	public ResponseEntity<?> getTrainee(@PathVariable("id")  int id) {
		Trainee ts = sd.getTrainee(id);
		if(ts==null)
			return new ResponseEntity<String>("Trainee with id "+id+" not found",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Trainee>(ts,HttpStatus.OK);
	}
	
	@GetMapping("Byname/{getNames}")
	public List<Trainee> getAllTraineeName(@PathVariable("getNames")String name){
		return sd.getByNames(name);
		
	}
	
	@PostMapping("{id}/{name}/{domain}/{loc}")
	public String insertTrainee(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("domain") String domain,@PathVariable("loc") String loc) {
		Trainee ts= new Trainee();
		ts.setTraineeId(id);
		ts.setName(name);
		ts.setDomain(domain);
		ts.setLocation(loc);
		if(sd.add(ts)) {
			return "add successfully";
		}
		return "Not Added";
	}
	
	@DeleteMapping("{id}")
	public String deleteTrainee(@PathVariable("id") int id) {
		if(sd.delete(id)) {
			return "Delete successfully";
		}
		return "Faild to delete";
		
	}
	
	

}

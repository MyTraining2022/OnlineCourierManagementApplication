package com.cg.trg.boot.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.trg.boot.dto.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	
	

}

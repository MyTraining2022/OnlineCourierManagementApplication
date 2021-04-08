package com.cg.trg.boot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.trg.boot.dto.Employee;
import com.cg.trg.boot.exceptions.DuplicateEmployeeException;
import com.cg.trg.boot.repository.EmployeeRepository;

@Component("jpaDao")
public class EmployeeDaoJpaImpl implements EmployeeDAO {
	@Autowired
	EmployeeRepository repository;
	
	
	

	public EmployeeDaoJpaImpl() {
		

	}

	@Override
	public void save(Employee e) throws DuplicateEmployeeException {
		try {
			repository.save(e);
		} catch (EntityExistsException ex) {
			throw new DuplicateEmployeeException("Employee you supplied is duplicate");
		}
	}

	@Override
	public boolean update(Employee e) {

		if (repository.findById(e.getEmpId()).isPresent()) {
			repository.save(e);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {

		Optional<Employee> e = repository.findById(id);
		if (e.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Employee getEmployee(int id) {
		Optional<Employee> e = repository.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		else {
			return null;
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> list = (List<Employee>) repository.findAll();
		
		return list;
	}

}

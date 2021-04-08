package com.cg.trg.boot.service;

import java.util.ArrayList;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cg.trg.boot.dao.EmployeeDAO;
import com.cg.trg.boot.dao.EmployeeDAOMapImpl;
import com.cg.trg.boot.dto.Employee;
import com.cg.trg.boot.exceptions.DuplicateEmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	@Qualifier("jpaDao")
	EmployeeDAO dao;

	@Override
	public boolean add(Employee e) {
		
		try {
			dao.save(e);
			return true;
		}
		catch(DuplicateEmployeeException ex) {
			return false;
		}
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}
	@Override
	public String delete(int... id) {
		// TODO Auto-generated method stub
		List<String> message = new ArrayList<String>();
		for(int i:id) {
			
			if(dao.delete(i)) {
				message.add("employee with employee id"+id+"successfully deleted");
			}
			else {
				message.add("employee with employee with id"+id+"doesn't exist");
			}
		}
		return message.stream().collect(Collectors.joining());
	}

	@Override
	public float getTotalSalary() {
		double totalSalary = 
		dao.getAllEmployees().stream().mapToDouble(Employee::getSalary).sum();
		
		return (float)totalSalary;
	}

	@Override
	public List<String> getAllNames() {
		List<Employee> list = dao.getAllEmployees();
		if(list.size() == 0) {
			return null;
		}
		return list.stream().map(Employee::getName).collect(Collectors.toList());
	}

	@Override
	public boolean updateSalary(int id, float salary) {
		Employee e = dao.getEmployee(id);
		if(e==null) {
			return false;
		}
		e.setSalary(salary);
		return dao.update(e);
		
	}

	@Override
	public Employee getEmployee(int id) {
		return dao.getEmployee(id);
	}

	@Override
	public String updateSalary(float salary, int... id) {
		List<String> message = new ArrayList<String>();
		
		for(int i:id) {
			Employee e = dao.getEmployee(i);
			if(e == null) {
				message.add("No employess found");
			}
			e.setSalary(salary);
			dao.update(e);
			message.add("Employee with id"+id+"successfully updated");
		}
		return message.stream().collect(Collectors.joining());
	}

	@Override
	public boolean update(Employee e) {
		
		return dao.update(e);
	}

	

}

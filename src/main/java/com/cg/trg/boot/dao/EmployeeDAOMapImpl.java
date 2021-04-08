package com.cg.trg.boot.dao;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cg.trg.boot.dto.Employee;
import com.cg.trg.boot.exceptions.DuplicateEmployeeException;

@Component("mapDao")
public class EmployeeDAOMapImpl implements EmployeeDAO{
	
	Map<Integer, Employee> data = new HashMap<Integer, Employee>();
	
	public EmployeeDAOMapImpl(){
		data.put(100, new Employee(100,"Ankit",10000));
		data.put(200, new Employee(200,"Ayush",10000));
		data.put(300, new Employee(300,"Ashish",10000));
		data.put(400, new Employee(400,"Tanvir",10000));
		data.put(500, new Employee(500,"Ritik",10000));
	}

	@Override
	public void save(Employee e) throws DuplicateEmployeeException {
		if(data.containsKey(e.getEmpId())) {
				throw new DuplicateEmployeeException("Employee id with empId:"+e.getEmpId()+" already exists");
		}
		data.put(e.getEmpId(), e);
		
	}

	@Override
	public boolean update(Employee e) {
		if(data.containsKey(e.getEmpId())) {
			data.put(e.getEmpId(), e);
			return true;	
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		if(data.containsKey(id)) {
			data.remove(id);
			return true;	
		}
		return false;
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return data.get(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return data.values().stream().collect(Collectors.toList());
	}

}

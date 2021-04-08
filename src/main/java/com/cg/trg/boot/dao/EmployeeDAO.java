package com.cg.trg.boot.dao;

import java.util.List;


import com.cg.trg.boot.dto.Employee;
import com.cg.trg.boot.exceptions.DuplicateEmployeeException;

public interface EmployeeDAO {
	void save(Employee e) throws DuplicateEmployeeException;
	boolean update(Employee e);
	boolean delete(int id);
	Employee getEmployee(int id);
	List<Employee> getAllEmployees();

}

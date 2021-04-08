package com.cg.trg.boot.service;

import java.util.List;


import com.cg.trg.boot.dto.Employee;

public interface EmployeeService {
	boolean add(Employee e);
	List<Employee> getAll();
	boolean delete(int id);
	String delete(int ...id);
	float getTotalSalary();
	List<String> getAllNames();
	boolean updateSalary(int id, float salary);
	String updateSalary(float salary, int ...id);
	Employee getEmployee(int id);
	boolean update(Employee e);

}

package com.cg.trg.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.trg.boot.dto.Employee;
import com.cg.trg.boot.service.EmployeeService;
import com.google.common.net.MediaType;

@RestController
@RequestMapping("employees")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@GetMapping(value="{eid}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE, org.springframework.http.MediaType.APPLICATION_XML_VALUE} )
	public ResponseEntity<?> getEmployee(@PathVariable("eid") int empId) {
		Employee e =  service.getEmployee(empId);
		if(e == null) {
			return new ResponseEntity<String>("Employee with employee id:"+empId+" not found",HttpStatus.NOT_FOUND);
			
		}
		else {
			return new ResponseEntity<Employee>(e,HttpStatus.OK);
		}
		
	}
	
	@GetMapping
	public List<Employee> getAllEmployee(){
		return service.getAll();	
	}
	@PostMapping
	public String saveEmployee(Employee e) {
		if(service.add(e)) {
			return "Employee Data saved successfully";
		}
		else {
			return "Employee Data is duplicate";
		}
		
	}
	
	@PostMapping("{eid}/{name}/{salary}")
	public String updateEmployee(@PathVariable("eid")int empId, @PathVariable("name")String name, @PathVariable("salary")double salary) {
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setName(name);
		emp.setSalary(salary);
		if(service.update(emp)) {
			return "Employee Data successfully updated";
		}
		else {
			return "Employee Data is duplicate";
		}
	}
	@PatchMapping("{eid}/{salary}")
	public String updateSalary(@PathVariable("eid")int empId, @PathVariable("salary")double salary) {
			Employee e = service.getEmployee(empId);
			if(e==null) {
				return "Employee with salary not found";
			}
			e.setSalary(salary);
			service.update(e);
			return "Employee updated successfully";
	}
	@PutMapping
	public String updateEmployee(Employee e) {
		if(service.update(e)) {
			return "Employee Data successfully updated";
		}
		else {
			return "Employee Data not found";
		}
	}
	@DeleteMapping("{eid}")
	public String deleteEmployee(@PathVariable("eid") int empId) {
		if(service.delete(empId)) {
			return "Employee data deleted successfully";
			
		}
		else {
			return "Employee to delete not found";
		}
	}
}

package com.cg.mts.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
	//List<Customer> findByName(String name); //from Employee e where e.name=name
	//List<Customer> findBySalary(float salary);
	//@Query("from Employee e where e.salary between :low and :high")
	
	//List<Employee> getBySalaryRange(@Param("low") float lowSal, @Param("high") float highSal);

}

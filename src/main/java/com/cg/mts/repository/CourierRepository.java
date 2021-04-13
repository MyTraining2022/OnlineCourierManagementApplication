package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Courier;
import com.cg.mts.entities.CourierStatus;

@Repository
public interface CourierRepository extends CrudRepository<Courier, Integer> {
	
	@Query("Select c.status from Courier c where c.courierId = :Id")
	CourierStatus getStatus(@Param("Id")int courierId);
	
}

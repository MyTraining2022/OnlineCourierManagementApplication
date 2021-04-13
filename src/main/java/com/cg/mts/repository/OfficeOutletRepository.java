package com.cg.mts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.CourierOfficeOutlet;

@Repository
public interface OfficeOutletRepository extends CrudRepository<CourierOfficeOutlet, Integer> {

	CourierOfficeOutlet findByOfficeId(int officeId);
}

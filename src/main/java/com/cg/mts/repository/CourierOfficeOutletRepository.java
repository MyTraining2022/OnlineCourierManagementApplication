package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.CourierOfficeOutlet;

@Repository
public interface CourierOfficeOutletRepository extends JpaRepository<CourierOfficeOutlet, Integer>{

	CourierOfficeOutlet findByOfficeId(int id);
}

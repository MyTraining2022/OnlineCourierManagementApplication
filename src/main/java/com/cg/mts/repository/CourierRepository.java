package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mts.entities.Courier;

public interface CourierRepository extends JpaRepository<Courier, Integer> {

}

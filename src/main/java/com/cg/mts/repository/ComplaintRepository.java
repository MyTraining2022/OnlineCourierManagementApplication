package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Complaint;


@Repository
public interface ComplaintRepository extends CrudRepository<Complaint, Integer> {

}

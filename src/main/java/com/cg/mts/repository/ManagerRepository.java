package com.cg.mts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Manager;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Integer>  {

}

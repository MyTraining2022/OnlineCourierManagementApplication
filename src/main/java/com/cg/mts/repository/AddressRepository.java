package com.cg.mts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>  {

}

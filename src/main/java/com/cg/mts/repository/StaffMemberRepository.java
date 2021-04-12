package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.OfficeStaffMember;

@Repository
public interface StaffMemberRepository extends JpaRepository<OfficeStaffMember, Integer> {
	OfficeStaffMember findByEmpId(int id);

}

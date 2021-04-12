package com.cg.mts.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mts.entities.Complaint;
import com.cg.mts.exceptions.ComplaintNotFoundException;
import com.cg.mts.repository.ComplaintRepository;

@Component("jpaComplaintDao")
public class ComplaintDao implements IComplaintDao {

	@Autowired
	ComplaintRepository repository;

	public ComplaintDao() {

	}

	@Override
	public void addNewComplaint(Complaint complaint) {
		// TODO Auto-generated method stub
		repository.save(complaint);

	}

	@Override
	public void removeComplaint(int complaintId) {
		// TODO Auto-generated method stub
		Optional<Complaint> complaint = repository.findById(complaintId);
		if (complaint.isPresent()) {
			repository.deleteById(complaintId);
		}

	}

	@Override
	public void updateComplaint(Complaint complaint) {
		// TODO Auto-generated method stub
		if (repository.findById(complaint.getComplaintId()).isPresent()) {
			repository.save(complaint);
		}
	}

	@Override
	public Complaint getComplaint(int complaintId) throws ComplaintNotFoundException {
		// TODO Auto-generated method stub
		Optional<Complaint> complaint = repository.findById(complaintId);
		if (complaint.isPresent()) {
			return complaint.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Complaint> getAllComplaints() {
		// TODO Auto-generated method stub
		List<Complaint> list = (List<Complaint>) repository.findAll();

		return list;
	}

}

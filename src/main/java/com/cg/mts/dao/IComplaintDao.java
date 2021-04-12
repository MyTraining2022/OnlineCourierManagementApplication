package com.cg.mts.dao;

import java.util.List;

import com.cg.mts.entities.Complaint;
import com.cg.mts.exceptions.ComplaintNotFoundException;

public interface IComplaintDao {

	public void addNewComplaint(Complaint complaint);
	public void removeComplaint(int complaintId);
	public void updateComplaint(Complaint complaint);
	
	public Complaint getComplaint(int complaintid) throws ComplaintNotFoundException;
	public List<Complaint> getAllComplaints();
}

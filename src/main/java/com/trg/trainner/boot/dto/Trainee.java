package com.trg.trainner.boot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trainee")
public class Trainee {
	
	@Id
	@Column(name="traineeid")
	private int traineeId;
	private String name;
	private String domain;
	private String location;
	
	public Trainee() {
		
	}
	
	
	
	public Trainee(int traineeId, String name, String domain, String location) {
		super();
		this.traineeId = traineeId;
		this.name = name;
		this.domain = domain;
		this.location = location;
	}



	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}



	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", name=" + name + ", domain=" + domain + ", location=" + location
				+ "]";
	}
	
	

}

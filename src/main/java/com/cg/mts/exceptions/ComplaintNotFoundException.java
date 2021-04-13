package com.cg.mts.exceptions;

public class ComplaintNotFoundException extends RuntimeException {
	private String operation;

	public ComplaintNotFoundException(String operation, String message) {
		super(message);
		this.operation=operation;
		// TODO Auto-generated constructor stub
	}

	public String getOperation() {
		return operation;
	}

}

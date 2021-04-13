package com.cg.mts.exceptions;

public class CourierIdExistsException extends RuntimeException {
	public CourierIdExistsException(String message) {
		super(message);
	}
}

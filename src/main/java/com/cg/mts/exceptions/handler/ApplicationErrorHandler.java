package com.cg.mts.exceptions.handler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.mts.exceptions.CustomerNotFoundException;
import com.cg.mts.exceptions.DuplicateCustomerException;
import com.cg.mts.exceptions.EmtyDataException;

@ControllerAdvice
public class ApplicationErrorHandler extends ResponseEntityExceptionHandler{
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorList=
		ex.getBindingResult()
		  .getFieldErrors()
		  .stream()
		  .map(fe-> fe.getDefaultMessage())
		  .collect(Collectors.toList());
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("Dataerror","problem in data received");
		errorBody.put("timetamp", LocalDateTime.now());
		errorBody.put("errors", errorList);
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DuplicateCustomerException.class)
	public ResponseEntity<?> handleDuplicateEntity(DuplicateCustomerException ex) {
		
		
		
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", "creation failed");
		errorBody.put("timetamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(EmtyDataException.class)
	public ResponseEntity<?> handleEmtyData(EmtyDataException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", "EmtyData");
		errorBody.put("timetamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<?> handleMissingEmployee(CustomerNotFoundException ex) {

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", ex.getOperation()+"failed");
		errorBody.put("timetamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);

	
		
		
		
		
	}

}

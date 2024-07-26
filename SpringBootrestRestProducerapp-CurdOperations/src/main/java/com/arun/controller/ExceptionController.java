package com.arun.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.arun.exception.EmployeeNotFoundException;
import com.arun.model.ExceptionData;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionController {
	
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionData> handleException(EmployeeNotFoundException e,HttpServletRequest request)
	{
		ExceptionData data=new ExceptionData();
		data.setMessage(e.getMessage());
		data.setPath(request.getRequestURL().toString());
		data.setStatusCode(HttpStatus.NOT_FOUND.value());
		data.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionData> handleException(Exception e,HttpServletRequest request)
	{
		ExceptionData data=new ExceptionData();
		data.setMessage(e.getMessage());
		data.setPath(request.getRequestURL().toString());
		data.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		data.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}

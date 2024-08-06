package com.arun.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(AuthorizationDeniedException.class)
	public ResponseEntity<String> handler(AuthorizationDeniedException exception)
	{
		return new ResponseEntity<>("Access denied",HttpStatus.FORBIDDEN);
	}

}

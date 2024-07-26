package com.arun.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
public class ExceptionData {
   
	private Integer statusCode;
	
	private String message;
	
	private LocalDateTime timestamp;
	
	private String path;
	
	 
	
}

package com.arun.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer employeeId;
	
	private String employeeName;
	
	private String employeeDesination;
	
	private String project;
	
	private String role;
	
	private String maritalStatus;
	
	private String empolymentType;
	
	private Double salary;
	
	private Boolean active;
	
	@CreationTimestamp
	@JsonIgnore
	private LocalDateTime createdTimeStamp;
	
	@UpdateTimestamp
	@JsonIgnore
	private LocalDateTime updateTimeStamp;
	
}

package com.arun.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee {

	@NonNull
	private Integer eNo;
	
	@NonNull
	private String eName;

	private Boolean status;
	
	private Address address;
	
	private String[] friends;
	 
	private Set<String> colors;
	
	private List<String> skills;
	
	private LocalDate dob;
	
	private List<Map<String,Object>> idDetails;
	
	private List<Department> departments;
}

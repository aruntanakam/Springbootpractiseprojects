package com.arun.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	private String hno;
	
	private String street;
	
	private String city;
	
	private String state;

}

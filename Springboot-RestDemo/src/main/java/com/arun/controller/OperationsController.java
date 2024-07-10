package com.arun.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.model.Address;
import com.arun.model.Department;
import com.arun.model.Employee;

@RestController
@RequestMapping("/emp-api")
public class OperationsController {

	@GetMapping("/getemp")
	public ResponseEntity<Employee> getEmployee()

	{
		
		  Employee e = new Employee(10, "Arun", true, new Address("15", "bank", "kmm",
		  "tg"), new String[] { "kumar", "taakaam" }, Set.of("red", "blue"),
		  List.of("java", "python"),
		  
		  LocalDate.of(2000, 7, 1), List.of(Map.of("aadhar", 2345), Map.of("pan", "cwjpa34")),
		  List.of(new Department(12, "sales"), new Department(13, "marketing")));
		 
		//Employee e=new Employee(2,"arun");
		
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	
	@GetMapping("/getemps")
	public ResponseEntity<List<Employee>> getEmployees()

	{
		
		  Employee e1 = new Employee(10, "Arun", true, new Address("15", "bank", "kmm",
		  "tg"), new String[] { "kumar", "taakaam" }, Set.of("red", "blue"),
		  List.of("java", "python"),
		  
		  LocalDate.of(2000, 7, 1), List.of(Map.of("aadhar", 2345), Map.of("pan", "cwjpa34")),
		  List.of(new Department(12, "sales"), new Department(13, "marketing")));
		  
		  Employee e2 = new Employee(10, "Arun", true, new Address("15", "bank", "kmm",
				  "tg"), new String[] { "kumar", "taakaam" }, Set.of("red", "blue"),
				  List.of("java", "python"),
				  
				  LocalDate.of(2000, 7, 1), List.of(Map.of("aadhar", 2345), Map.of("pan", "cwjpa34")),
				  List.of(new Department(12, "sales"), new Department(13, "marketing")));
		 
		  
		
		return new ResponseEntity<>(List.of(e1,e2),HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Employee e)
	{
		return new ResponseEntity<String>(e.toString(),HttpStatus.CREATED);
	}
	
	@PostMapping("/saveall")
	public ResponseEntity<String> saveAll(@RequestBody List<Employee> e)
	{
		return new ResponseEntity<String>(e.toString(),HttpStatus.CREATED);
	}
}

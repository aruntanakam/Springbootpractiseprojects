package com.arun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.entity.Employee;
import com.arun.service.IEmployeeManagementService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/employee/api")
public class EmployeeOperationsController {
	
	@Autowired
	private IEmployeeManagementService empService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerEmployee(@RequestBody Employee e)
	{
		
		return new ResponseEntity<>(empService.registerEmployee(e),HttpStatus.CREATED);
	}
	
	@GetMapping(value={"/get/emp/{id}","/get/emps/active","/get/emps"})
	public ResponseEntity<Object> getEmployee(@PathVariable(required = false) Integer id,HttpServletRequest request)
	{
		String requestedPath=request.getRequestURL().toString();
		
	   if(requestedPath.contains("active"))
	   {
		   return new ResponseEntity<>(empService.getActiveEmployees(),HttpStatus.OK); 
	   }
	   else if(requestedPath.contains("emps"))
	   {
		   return new ResponseEntity<>(empService.getEmployees(),HttpStatus.OK); 
	   }
	   else
	   {
		   return new ResponseEntity<>(empService.getEmployee(id),HttpStatus.OK); 
	   }
	
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee e)
	{
		return new ResponseEntity<>(empService.updateEmployee(e),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>  deleteEmployee(@PathVariable Integer id)
	{
		return new ResponseEntity<>(empService.deleteEmployee(id),HttpStatus.OK);
	}
	
	@PatchMapping("/update/{id}/{status}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer id,@PathVariable Boolean status)
	{
		return new ResponseEntity<>(empService.updateStatus(id, status),HttpStatus.OK);
	}
	
	
	
	
	
	

}

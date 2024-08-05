package com.arun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger log=LoggerFactory.getLogger(EmployeeOperationsController.class);
	
	@Autowired
	private IEmployeeManagementService empService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerEmployee(@RequestBody Employee e)
	{
		log.info("Eneterd methood to rgeister employee");
		
		return new ResponseEntity<>(empService.registerEmployee(e),HttpStatus.CREATED);
	}
	
	@GetMapping(value={"/get/emp/{id}","/get/emps/active","/get/emps"})
	public ResponseEntity<Object> getEmployee(@PathVariable(required = false) Integer id,HttpServletRequest request)
	{
		String requestedPath=request.getRequestURL().toString();
		
	   if(requestedPath.contains("active"))
	   {
		   log.info("Eneterd methood to get active employees");
		   return new ResponseEntity<>(empService.getActiveEmployees(),HttpStatus.OK); 
	   }
	   else if(requestedPath.contains("emps"))
	   {
		   log.info("Eneterd methood to get all employees");
		   return new ResponseEntity<>(empService.getEmployees(),HttpStatus.OK); 
	   }
	   else
	   {
		   log.info("Eneterd methood to get  employee with id:"+id);
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

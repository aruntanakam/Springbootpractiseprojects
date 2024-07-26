package com.arun.service;

import java.util.List;

import com.arun.entity.Employee;

public interface IEmployeeManagementService {
	
	public String registerEmployee(Employee e);
	
	public Employee getEmployee(Integer id);
	
	public List<Employee> getEmployees();
	
	public String updateEmployee(Employee e);
	
	public String deleteEmployee(Integer id);
	
	public String updateStatus(Integer id,Boolean status);
	
	public List<Employee> getActiveEmployees();

}

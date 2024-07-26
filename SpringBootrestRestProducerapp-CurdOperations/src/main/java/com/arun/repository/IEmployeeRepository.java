package com.arun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arun.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
	
	public List<Employee> findByActive(Boolean active);

}

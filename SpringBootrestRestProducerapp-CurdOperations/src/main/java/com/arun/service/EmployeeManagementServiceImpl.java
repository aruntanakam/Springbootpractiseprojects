package com.arun.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.entity.Employee;
import com.arun.exception.EmployeeNotFoundException;
import com.arun.repository.IEmployeeRepository;

@Service
public class EmployeeManagementServiceImpl implements IEmployeeManagementService {

	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public String registerEmployee(Employee e) {

		e = empRepo.save(e);
		if (e.getEmployeeId() == null) {
			throw new RuntimeException("problem in  registering employee");
		}

		return "Employee is registered with id:" + e.getEmployeeId();
	}

	@Override
	public Employee getEmployee(Integer id) {

		Optional<Employee> opt = empRepo.findById(id);

		return opt.orElseThrow(() -> new EmployeeNotFoundException("There is no employee with given id:" + id));
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employeeList = empRepo.findAll();

		return employeeList;
	}

	@Override
	public String updateEmployee(Employee e) {
		Optional<Employee> opt = empRepo.findById(e.getEmployeeId());

		if (opt.isPresent()) {
			empRepo.save(e);
			return "Employee with id:" + e.getEmployeeId() + " updated succcessfully";
		}

		throw new EmployeeNotFoundException("There is no employee with given id:" + e.getEmployeeId());
	}

	@Override
	public String deleteEmployee(Integer id) {
		Optional<Employee> opt = empRepo.findById(id);

		if (opt.isPresent()) {
			empRepo.deleteById(id);
			return "Employee with id:"+id+" got deleted sucessfully";
		}

		throw new EmployeeNotFoundException("There is no employee with given id:" + id);
	}

	@Override
	public String updateStatus(Integer id, Boolean status) {

		Optional<Employee> opt = empRepo.findById(id);

		if (opt.isPresent()) {
			Employee e = opt.get();
			e.setActive(status);
			empRepo.save(e);
			return "Employee with id:"+id+"active  status updated to "+status;
		}

		throw new EmployeeNotFoundException("There is no employee with given id:" + id);
	}

	@Override
	public List<Employee> getActiveEmployees() {

		return empRepo.findByActive(true);
	}

}

package com.suresh.employee_service.service;

import com.suresh.employee_service.entity.Employee;
import com.suresh.employee_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee getEmployee(Long empId) {
		return employeeRepository.findByEmployeeId(empId);
	}

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
}

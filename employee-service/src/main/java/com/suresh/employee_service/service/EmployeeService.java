package com.suresh.employee_service.service;

import com.suresh.employee_service.dto.EmployeeDTO;
import com.suresh.employee_service.entity.Employee;
import com.suresh.employee_service.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ModelMapper modelMapper;

	public EmployeeDTO getEmployee(Long empId) {
		Employee employee = employeeRepository.findByEmployeeId(empId);
		return modelMapper.map(employee, EmployeeDTO.class);
	}

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
}

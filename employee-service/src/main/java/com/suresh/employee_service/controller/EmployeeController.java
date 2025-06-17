package com.suresh.employee_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.employee_service.entity.Employee;
import com.suresh.employee_service.service.EmployeeService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/")
	public String employeeHome() {
		return "Welcome to suresh microservices";
	}
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<Employee> getEmployeeByEmpId(@PathVariable Long empId) {
		Employee emp = employeeService.getEmployee(empId);
		return ResponseEntity.ok().body(emp);
	}
	
	@PostMapping("/add-employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.addEmployee(employee);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/add-employee")
				.buildAndExpand(emp.getEmployeeId())
				.toUri();
		return ResponseEntity.created(location).body(employee);
	}
}

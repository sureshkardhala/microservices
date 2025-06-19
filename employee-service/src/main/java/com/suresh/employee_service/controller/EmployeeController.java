package com.suresh.employee_service.controller;

import com.suresh.employee_service.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.suresh.employee_service.entity.Employee;
import com.suresh.employee_service.service.EmployeeService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/employee-api")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/")
	public String employeeHome() {
		return "Welcome to suresh microservices";
	}
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<EmployeeDTO> getEmployeeByEmpId(@PathVariable Long empId) {
		EmployeeDTO employeeDTO = employeeService.getEmployeeByEmpId(empId);
		return ResponseEntity.ok().body(employeeDTO);
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

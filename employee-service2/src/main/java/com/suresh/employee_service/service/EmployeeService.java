package com.suresh.employee_service.service;

import com.suresh.employee_service.dto.AddressDTO;
import com.suresh.employee_service.dto.EmployeeDTO;
import com.suresh.employee_service.entity.Employee;
import com.suresh.employee_service.feignclient.AddressFeignClient;
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
	@Autowired
	private AddressFeignClient addressFeignClient;

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public EmployeeDTO getEmployeeByEmpId(Long empId) {
		AddressDTO addressDTO = addressFeignClient.getAddressByEmployeeId(empId).getBody();
		Employee employee = employeeRepository.findByEmployeeId(empId);
		EmployeeDTO employeeDTO=modelMapper.map(employee, EmployeeDTO.class);
		employeeDTO.setAddressDTO(addressDTO);
		return  employeeDTO;
	}
}

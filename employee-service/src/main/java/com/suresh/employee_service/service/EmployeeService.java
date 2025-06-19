package com.suresh.employee_service.service;

import com.suresh.employee_service.dto.AddressDTO;
import com.suresh.employee_service.dto.EmployeeDTO;
import com.suresh.employee_service.entity.Employee;
import com.suresh.employee_service.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private WebClient webClient;

//	@Autowired - should remove if we use without bean and writing using builder
	private RestTemplate restTemplate;

//	@Value("${address-service.base.url}")
	private String baseUrl;

	//Way of creating bean for rest template & we have to remove autowire for resttemplate if we use this
	public EmployeeService(@Value("${address-service.base.url}") String baseUrl,
						   RestTemplateBuilder restTemplateBuilder){
		this.restTemplate = restTemplateBuilder.build();
	}

	//Using Rest template - Communicating services
	public EmployeeDTO getEmployeeByRestTemplate(Long empId) {
		baseUrl ="http://localhost:8081/address-api/employee/{id}";
		AddressDTO addressDTO = restTemplate.getForObject(baseUrl, AddressDTO.class ,empId);
		Employee employee = employeeRepository.findByEmployeeId(empId);
		EmployeeDTO employeeDTO=modelMapper.map(employee, EmployeeDTO.class);
		employeeDTO.setAddressDTO(addressDTO);
		return  employeeDTO;
	}

	//Using webclient - Communicating services
	public EmployeeDTO getEmployeeByWebClient(Long empId) {
		AddressDTO addressDTO = webClient
				.get()
				.uri("/employee/"+empId)
				.retrieve()
				.bodyToMono(AddressDTO.class)
				.block();
		Employee employee = employeeRepository.findByEmployeeId(empId);
		EmployeeDTO employeeDTO=modelMapper.map(employee, EmployeeDTO.class);
		employeeDTO.setAddressDTO(addressDTO);
		return  employeeDTO;
	}

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public EmployeeDTO getEmployeeByEmpId(Long empId) {
		return getEmployeeByRestTemplate(empId);
	}
}

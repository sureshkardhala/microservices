package com.suresh.employee_service.service;

import com.suresh.employee_service.dto.AddressDTO;
import com.suresh.employee_service.dto.EmployeeDTO;
import com.suresh.employee_service.entity.Employee;
import com.suresh.employee_service.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private WebClient webClient;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

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
		//Now url getting dynamically from service discovery
		//1. Using discovery client get all instances
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances("address-service-for-service-discovery");
		ServiceInstance serviceInstance = serviceInstances.getFirst();
		Map<String, String> hMap = serviceInstance.getMetadata();
		String dynamicUri = serviceInstance.getUri().toString();
		dynamicUri+=hMap.getOrDefault("configpath","/address-api");
		dynamicUri+="/employee/{id}";
		System.out.println("Dynamic Uri from discovery client >>>>>>" + dynamicUri);
		System.out.println();
		System.out.println();

		//2. Using LoadBalancer Client it chooses loadbalancer by choice
		ServiceInstance serviceInstance1 = loadBalancerClient.choose("address-service-for-service-discovery");
		String  dynamicUri2 = serviceInstance1.getUri().toString();
		dynamicUri2+=serviceInstance1.getMetadata().getOrDefault("configpath", "/address-api");
		dynamicUri2+="/employee/{id}";
		System.out.println("Dynamic URI from load balancer >>>> "+ dynamicUri2);
		System.out.println();
		System.out.println();

		AddressDTO addressDTO1 = restTemplate.getForObject(dynamicUri, AddressDTO.class ,empId);
		AddressDTO addressDTO2 = restTemplate.getForObject(dynamicUri2, AddressDTO.class ,empId);

		System.out.println("Address DTO From Loadbalancer client"+ addressDTO2.toString());
		System.out.println("Address DTO From Discovery client"+addressDTO1.toString());
		System.out.println();


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

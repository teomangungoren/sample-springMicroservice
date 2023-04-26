package com.teomangungoren.employeeservice.service.impl;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.teomangungoren.employeeservice.dto.APIResponseDto;
import com.teomangungoren.employeeservice.dto.DepartmentDto;
import com.teomangungoren.employeeservice.dto.EmployeeDto;
import com.teomangungoren.employeeservice.dto.OrganizationDto;
import com.teomangungoren.employeeservice.entity.Employee;
import com.teomangungoren.employeeservice.mapper.EmployeeMapper;
import com.teomangungoren.employeeservice.repository.EmployeeRepository;
import com.teomangungoren.employeeservice.service.APIClient;
import com.teomangungoren.employeeservice.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
	

	private EmployeeRepository employeeRepository;
	
	//private RestTemplate restTemplate;
	private WebClient webClient;
	
	private APIClient apiClient;
	
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		
		Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
		
		Employee savedEmployee=employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
		
	}

	//@CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
	//@Retry(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {
		
	

	Employee employee=employeeRepository.findById(employeeId).get();
	
//	ResponseEntity<DepartmentDto> responseEntity=restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(),
//			DepartmentDto.class);
	
	//DepartmentDto departmentDto=responseEntity.getBody();
	
	DepartmentDto departmentDto1= webClient.get()
	         .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
	         .retrieve()
	         .bodyToMono(DepartmentDto.class)
	         .block();
	
	OrganizationDto organizationDto=webClient.get()
			.uri("http://localhost:8084/api/organizations/"+employee.getOrganizationCode())
			.retrieve()
			.bodyToMono(OrganizationDto.class)
			.block();
	
	//DepartmentDto departmentDto=apiClient.getDepartment(employee.getDepartmentCode());
	
	EmployeeDto employeeDto=EmployeeMapper.mapToEmployeeDto(employee);
	
	
	APIResponseDto apiResponseDto=new APIResponseDto();
	apiResponseDto.setDepartmentDto(departmentDto1);
	apiResponseDto.setEmployeeDto(employeeDto);
	apiResponseDto.setOrganizationDto(organizationDto);
	
		return apiResponseDto;
	}


	
	
	
}

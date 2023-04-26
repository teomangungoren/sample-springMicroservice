package com.teomangungoren.employeeservice.service;

import com.teomangungoren.employeeservice.dto.APIResponseDto;
import com.teomangungoren.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

	public EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	public APIResponseDto getEmployeeById(Long employeeId);
}

package com.teomangungoren.employeeservice.mapper;

import com.teomangungoren.employeeservice.dto.EmployeeDto;
import com.teomangungoren.employeeservice.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartmentCode(),
				employee.getOrganizationCode()
				);
		}
	
	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail(),
				employeeDto.getDepartmentCode(),
				employeeDto.getOrganizationCode())
				;
	}
}

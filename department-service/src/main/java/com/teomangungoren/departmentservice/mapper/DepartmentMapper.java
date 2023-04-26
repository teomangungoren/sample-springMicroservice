package com.teomangungoren.departmentservice.mapper;

import com.teomangungoren.departmentservice.dto.DepartmentDto;
import com.teomangungoren.departmentservice.entity.Department;

public class DepartmentMapper {

	public static DepartmentDto mapToDepartmentDto(Department department) {
	
		
		return new DepartmentDto(
				department.getId(),
				department.getDepartmentName(),
				department.getDepartmentDescription(),
				department.getDepartmentCode());
		
	}
	
	public static Department mapToDepartment(DepartmentDto departmentDto) {
		
		return new Department(
				departmentDto.getId(),
				departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription(),
				departmentDto.getDepartmentCode());
				
	}
	
	
}

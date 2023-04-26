package com.teomangungoren.departmentservice.service;

import com.teomangungoren.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	
	DepartmentDto getDepartmentByCode(String code);
	}

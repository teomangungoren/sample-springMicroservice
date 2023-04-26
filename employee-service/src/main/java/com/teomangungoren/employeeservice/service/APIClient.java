package com.teomangungoren.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.teomangungoren.employeeservice.dto.DepartmentDto;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

	@GetMapping("api/departments/{department-code}")
	 DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
	
}

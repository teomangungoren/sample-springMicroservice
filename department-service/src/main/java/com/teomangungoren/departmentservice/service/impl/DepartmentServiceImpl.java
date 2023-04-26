package com.teomangungoren.departmentservice.service.impl;

import org.springframework.stereotype.Service;

import com.teomangungoren.departmentservice.dto.DepartmentDto;
import com.teomangungoren.departmentservice.entity.Department;
import com.teomangungoren.departmentservice.mapper.DepartmentMapper;
import com.teomangungoren.departmentservice.repository.DepartmentRepository;
import com.teomangungoren.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		
		Department department=DepartmentMapper.mapToDepartment(departmentDto);
		
		Department saveDepartment=departmentRepository.save(department);
		
		return DepartmentMapper.mapToDepartmentDto(saveDepartment);
	}

	@Override
	public DepartmentDto getDepartmentByCode(String code) {
		
		Department department=departmentRepository.findByDepartmentCode(code);
		
		return DepartmentMapper.mapToDepartmentDto(department);
	
		
		
	}

	
}

package com.teomangungoren.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teomangungoren.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByDepartmentCode(String departmentCode);

	
}

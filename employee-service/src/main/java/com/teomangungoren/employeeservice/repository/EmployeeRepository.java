package com.teomangungoren.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teomangungoren.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	
}

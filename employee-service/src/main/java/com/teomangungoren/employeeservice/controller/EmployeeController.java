package com.teomangungoren.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teomangungoren.employeeservice.dto.APIResponseDto;
import com.teomangungoren.employeeservice.dto.EmployeeDto;
import com.teomangungoren.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
		
		EmployeeDto savedEmployee=employeeService.saveEmployee(employeeDto);
		
		return new ResponseEntity<EmployeeDto>(savedEmployee,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long id){
		
		APIResponseDto apiResponseDto=employeeService.getEmployeeById(id);
		
		return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
		
	}
	
	
}

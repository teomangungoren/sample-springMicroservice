package com.teomangungoren.organizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teomangungoren.organizationservice.dto.OrganizationDto;
import com.teomangungoren.organizationservice.service.OrganizationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/organizations")
public class OrganizationController {

	private OrganizationService organizationService;
	
	@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
		
		OrganizationDto savedOrganizationDto= organizationService.saveOrganizationDto(organizationDto);
		
		return new ResponseEntity<>(savedOrganizationDto,HttpStatus.CREATED);
	}
	
	@GetMapping("{code}")
	public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
		
	OrganizationDto organizationDto= organizationService.getOrganizationByCode(organizationCode);
		
		return new ResponseEntity<>(organizationDto,HttpStatus.OK);
	}
}

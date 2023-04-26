package com.teomangungoren.organizationservice.service;

import com.teomangungoren.organizationservice.dto.OrganizationDto;

public interface OrganizationService {

	OrganizationDto saveOrganizationDto(OrganizationDto organizationDto);
	
	OrganizationDto getOrganizationByCode(String organizationCode);
}

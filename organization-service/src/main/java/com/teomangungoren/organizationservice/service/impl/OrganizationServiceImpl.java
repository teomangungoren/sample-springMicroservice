package com.teomangungoren.organizationservice.service.impl;

import org.springframework.stereotype.Service;

import com.teomangungoren.organizationservice.dto.OrganizationDto;
import com.teomangungoren.organizationservice.entity.Organization;
import com.teomangungoren.organizationservice.mapper.OrganizationMapper;
import com.teomangungoren.organizationservice.repository.OrganizationRepository;
import com.teomangungoren.organizationservice.service.OrganizationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrganizationServiceImpl implements OrganizationService {

	private OrganizationRepository organizationRepository;
	
	@Override
	public OrganizationDto saveOrganizationDto(OrganizationDto organizationDto) {
		
		Organization organization=OrganizationMapper.mapToOrganization(organizationDto);
		
		Organization savedOrganization=organizationRepository.save(organization);
		
		return OrganizationMapper.mapToOrganizationDto(savedOrganization);
		
	}

	@Override
	public OrganizationDto getOrganizationByCode(String organizationCode) {

		Organization organization=organizationRepository.findByOrganizationCode(organizationCode);
		
		return OrganizationMapper.mapToOrganizationDto(organization);

	}

}

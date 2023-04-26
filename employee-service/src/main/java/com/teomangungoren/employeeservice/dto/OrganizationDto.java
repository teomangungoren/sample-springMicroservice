package com.teomangungoren.employeeservice.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrganizationDto {

	private Long id;
	private String organizationName;
	private String organizationDescription;
	private String organizationCode;
	private LocalDateTime createdDate;
}

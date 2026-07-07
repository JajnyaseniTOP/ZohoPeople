package com.Zoho.Users.dto;

import java.time.LocalDate;

public class EmployeeHierarchyRequest {

    private String employeeCode;

    private String reportingManager;

    private String organizationLevel;

    private String clientName;

    private String clientReportingManager;

    private LocalDate clientOnboardingDate;
    

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	public String getOrganizationLevel() {
		return organizationLevel;
	}

	public void setOrganizationLevel(String organizationLevel) {
		this.organizationLevel = organizationLevel;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientReportingManager() {
		return clientReportingManager;
	}

	public void setClientReportingManager(String clientReportingManager) {
		this.clientReportingManager = clientReportingManager;
	}

	public LocalDate getClientOnboardingDate() {
		return clientOnboardingDate;
	}

	public void setClientOnboardingDate(LocalDate clientOnboardingDate) {
		this.clientOnboardingDate = clientOnboardingDate;
	}

   
}
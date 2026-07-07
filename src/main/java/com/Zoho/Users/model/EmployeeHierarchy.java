package com.Zoho.Users.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_hierarchy")
public class EmployeeHierarchy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hierarchy_id")
    private Long hierarchyId;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "reporting_manager")
    private String reportingManager;

    @Column(name = "organization_level")
    private String organizationLevel;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_reporting_manager")
    private String clientReportingManager;

    @Column(name = "client_onboarding_date")
    private LocalDate clientOnboardingDate;
    

	public Long getHierarchyId() {
		return hierarchyId;
	}

	public void setHierarchyId(Long hierarchyId) {
		this.hierarchyId = hierarchyId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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
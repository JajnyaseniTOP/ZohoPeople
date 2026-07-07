package com.Zoho.Users.dto;

import java.time.LocalDate;

public class EmployeeWorkResponse {

    private String employeeCode;

    private String company;

    private String department;

    private String location;

    private String designation;

    private String zohoRole;

    private String employmentType;

    private String employeeStatus;

    private String category;

    private LocalDate joiningDate;

    private String currentExperience;

    private String totalExperience;
    

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getZohoRole() {
		return zohoRole;
	}

	public void setZohoRole(String zohoRole) {
		this.zohoRole = zohoRole;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getCurrentExperience() {
		return currentExperience;
	}

	public void setCurrentExperience(String currentExperience) {
		this.currentExperience = currentExperience;
	}

	public String getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(String totalExperience) {
		this.totalExperience = totalExperience;
	}
    

    
}
package com.Zoho.Users.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_work")
public class EmployeeWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_id")
    private Long workId;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "company")
    private String company;

    @Column(name = "department")
    private String department;

    @Column(name = "location")
    private String location;

    @Column(name = "designation")
    private String designation;

    @Column(name = "zoho_role")
    private String zohoRole;

    @Column(name = "employment_type")
    private String employmentType;

    @Column(name = "employee_status")
    private String employeeStatus;

    @Column(name = "category")
    private String category;

    @Column(name = "joining_date")
    private LocalDate joiningDate;

    @Column(name = "current_experience")
    private String currentExperience;

    @Column(name = "total_experience")
    private String totalExperience;

    // Getters and Setters

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
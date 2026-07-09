package com.Zoho.Users.dto;

public class EmployeeDropdownResponse {

    private String employeeCode;
    private String employeeName;

    public EmployeeDropdownResponse() {
    }

    public EmployeeDropdownResponse(String employeeCode, String employeeName) {
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
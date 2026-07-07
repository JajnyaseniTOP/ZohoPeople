package com.Zoho.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Zoho.Users.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{
	
	Employee findByEmployeeCode(String employeeCode);

}

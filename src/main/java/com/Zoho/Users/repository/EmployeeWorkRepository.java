package com.Zoho.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Zoho.Users.model.Employee;
import com.Zoho.Users.model.EmployeeWork;

@Repository
public interface EmployeeWorkRepository  extends JpaRepository<EmployeeWork, Long>{
	EmployeeWork  findByEmployeeEmployeeCode(String employeeCode);
	 EmployeeWork findByEmployee(Employee employee);
}

package com.Zoho.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Zoho.Users.model.Employee;
import com.Zoho.Users.model.EmployeeBasic;

@Repository
public interface EmployeeBasicRepository extends JpaRepository<EmployeeBasic, Long>{
	 EmployeeBasic findByEmployee(Employee employee);
}

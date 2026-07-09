package com.Zoho.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Zoho.Users.model.Employee;
import com.Zoho.Users.model.EmployeeDependent;

public interface EmployeeDependentRepository extends JpaRepository<EmployeeDependent, Long> {

    EmployeeDependent findByEmployee(Employee employee);

}
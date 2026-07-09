package com.Zoho.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Zoho.Users.model.Employee;
import com.Zoho.Users.model.EmployeeSeparation;

public interface EmployeeSeparationRepository extends JpaRepository<EmployeeSeparation, Long> {

    EmployeeSeparation findByEmployee(Employee employee);

}
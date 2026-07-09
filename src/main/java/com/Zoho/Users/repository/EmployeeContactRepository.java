package com.Zoho.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Zoho.Users.model.Employee;
import com.Zoho.Users.model.EmployeeContact;

public interface EmployeeContactRepository extends JpaRepository<EmployeeContact, Long> {

    EmployeeContact findByEmployee(Employee employee);

}
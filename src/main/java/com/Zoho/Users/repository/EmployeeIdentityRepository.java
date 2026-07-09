package com.Zoho.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Zoho.Users.model.Employee;
import com.Zoho.Users.model.EmployeeIdentity;

public interface EmployeeIdentityRepository
        extends JpaRepository<EmployeeIdentity, Long> {

    EmployeeIdentity findByEmployee(Employee employee);

}
package com.Zoho.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Zoho.Users.model.Employee;
import com.Zoho.Users.model.EmployeePersonal;

public interface EmployeePersonalRepository extends JpaRepository<EmployeePersonal, Long> {

    EmployeePersonal findByEmployee(Employee employee);

}
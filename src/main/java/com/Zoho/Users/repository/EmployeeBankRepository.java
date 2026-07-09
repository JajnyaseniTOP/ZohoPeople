package com.Zoho.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Zoho.Users.model.Employee;
import com.Zoho.Users.model.EmployeeBank;

public interface EmployeeBankRepository extends JpaRepository<EmployeeBank, Long> {

    EmployeeBank findByEmployee(Employee employee);

}
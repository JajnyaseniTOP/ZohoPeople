package com.Zoho.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Zoho.Users.model.Employee;
import com.Zoho.Users.model.EmployeeHierarchy;

public interface EmployeeHierarchyRepository  extends JpaRepository<EmployeeHierarchy, Long> {

    EmployeeHierarchy findByEmployee(Employee employee);

}
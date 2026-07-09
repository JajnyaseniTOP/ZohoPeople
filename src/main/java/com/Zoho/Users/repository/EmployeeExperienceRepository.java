package com.Zoho.Users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Zoho.Users.model.Employee;
import com.Zoho.Users.model.EmployeeExperience;

public interface EmployeeExperienceRepository extends JpaRepository<EmployeeExperience, Long>{

    List<EmployeeExperience> findByEmployee(Employee employee);
}
package com.Zoho.Users.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Zoho.Users.model.Employee;
import com.Zoho.Users.model.EmployeeAttendance;

@Repository
public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendance,Long>{
    EmployeeAttendance findByEmployeeAndAttendanceDate(Employee employee,LocalDate attendanceDate);
}

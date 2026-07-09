package com.Zoho.Users.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_separation")
public class EmployeeSeparation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "separation_id")
    private Long separationId;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "date_of_exit")
    private LocalDate dateOfExit;

    @Column(name = "last_working_date")
    private LocalDate lastWorkingDate;

    public Long getSeparationId() {
        return separationId;
    }

    public void setSeparationId(Long separationId) {
        this.separationId = separationId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getDateOfExit() {
        return dateOfExit;
    }

    public void setDateOfExit(LocalDate dateOfExit) {
        this.dateOfExit = dateOfExit;
    }

    public LocalDate getLastWorkingDate() {
        return lastWorkingDate;
    }

    public void setLastWorkingDate(LocalDate lastWorkingDate) {
        this.lastWorkingDate = lastWorkingDate;
    }
}
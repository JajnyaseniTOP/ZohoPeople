package com.Zoho.Users.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_dependent")
public class EmployeeDependent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dependent_id")
    private Long dependentId;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "dependent_name")
    private String dependentName;

    @Column(name = "relationship")
    private String relationship;

    @Column(name = "dob")
    private LocalDate dob;

	public Long getDependentId() {
		return dependentId;
	}

	public void setDependentId(Long dependentId) {
		this.dependentId = dependentId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

    
    
  
}
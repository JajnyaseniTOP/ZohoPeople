package com.Zoho.Users.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_contact")
public class EmployeeContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long contactId;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "work_phone_number")
    private String workPhoneNumber;

    @Column(name = "emergency_contact_number")
    private String emergencyContactNumber;

    @Column(name = "extension")
    private String extension;

    @Column(name = "seating_location")
    private String seatingLocation;

    @Column(name = "tags")
    private String tags;

    @Column(name = "present_address")
    private String presentAddress;

    @Column(name = "permanent_address")
    private String permanentAddress;  

    @Column(name = "personal_mobile_number")
    private String personalMobileNumber;

    @Column(name = "alternate_contact_number")
    private String alternateContactNumber;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "personal_email_address")
    private String personalEmailAddress;

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}

	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}

	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}

	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getSeatingLocation() {
		return seatingLocation;
	}

	public void setSeatingLocation(String seatingLocation) {
		this.seatingLocation = seatingLocation;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPersonalMobileNumber() {
		return personalMobileNumber;
	}

	public void setPersonalMobileNumber(String personalMobileNumber) {
		this.personalMobileNumber = personalMobileNumber;
	}

	public String getAlternateContactNumber() {
		return alternateContactNumber;
	}

	public void setAlternateContactNumber(String alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getPersonalEmailAddress() {
		return personalEmailAddress;
	}

	public void setPersonalEmailAddress(String personalEmailAddress) {
		this.personalEmailAddress = personalEmailAddress;
	}



    
    
}
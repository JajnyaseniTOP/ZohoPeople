package com.Zoho.Users.service;

import java.util.List;

import com.Zoho.Users.dto.AttendanceResponse;
import com.Zoho.Users.dto.EmployeeBankRequest;
import com.Zoho.Users.dto.EmployeeBasicRequest;
import com.Zoho.Users.dto.EmployeeContactRequest;
import com.Zoho.Users.dto.EmployeeDependentRequest;
import com.Zoho.Users.dto.EmployeeDropdownResponse;
import com.Zoho.Users.dto.EmployeeExperienceRequest;
import com.Zoho.Users.dto.EmployeeHierarchyRequest;
import com.Zoho.Users.dto.EmployeeIdentityRequest;
import com.Zoho.Users.dto.EmployeeListResponse;
import com.Zoho.Users.dto.EmployeePersonalRequest;
import com.Zoho.Users.dto.EmployeeProfileResponse;
import com.Zoho.Users.dto.EmployeeRequest;
import com.Zoho.Users.dto.EmployeeSeparationRequest;
import com.Zoho.Users.dto.EmployeeWorkRequest;
import com.Zoho.Users.dto.LoginRequest;
import com.Zoho.Users.dto.LoginResponse;
import com.Zoho.Users.dto.NewHireResponse;
import com.Zoho.Users.dto.UserProfile;
import com.Zoho.Users.model.Employee;
import com.Zoho.Users.model.EmployeeBank;
import com.Zoho.Users.model.EmployeeBasic;
import com.Zoho.Users.model.EmployeeContact;
import com.Zoho.Users.model.EmployeeDependent;
import com.Zoho.Users.model.EmployeeExperience;
import com.Zoho.Users.model.EmployeeHierarchy;
import com.Zoho.Users.model.EmployeeIdentity;
import com.Zoho.Users.model.EmployeePersonal;
import com.Zoho.Users.model.EmployeeSeparation;
import com.Zoho.Users.model.EmployeeWork;
import com.Zoho.Users.model.User;

public interface UserService {

	LoginResponse login(LoginRequest request);
	//String getEmployeeCode(String email);
	//String getUserName(String userId);
	//String getUserEmail(String userId);
	//String getUserId(String userEmail);
	//String getRole(String userEmail);
	//UserProfile getSuperAdmin();
	Employee addEmployee(EmployeeRequest request);
	EmployeeWork addEmployeeWork(EmployeeWorkRequest request);

	User addUsers(User user);
	EmployeeBasic saveBasicInformation(EmployeeBasicRequest request);
	EmployeeHierarchy addEmployeeHierarchy(EmployeeHierarchyRequest request);
	List<EmployeeDropdownResponse> getAllEmployees();
	EmployeeIdentity saveEmployeeIdentity(EmployeeIdentityRequest request);
	EmployeeContact saveEmployeeContact(EmployeeContactRequest request);
	EmployeeSeparation saveEmployeeSeparation(EmployeeSeparationRequest request);
	EmployeeDependent saveEmployeeDependent(EmployeeDependentRequest request);
	EmployeePersonal saveEmployeePersonal(EmployeePersonalRequest request);
	EmployeeBank saveEmployeeBank(EmployeeBankRequest request);
	EmployeeExperience addEmployeeExperience(EmployeeExperienceRequest request);
	List<NewHireResponse> getNewHires();
	EmployeeProfileResponse getProfile(String employeeCode);
	
	AttendanceResponse checkIn(String employeeCode);
	AttendanceResponse checkOut(String employeeCode);
	AttendanceResponse getAttendanceStatus(String employeeCode);
	
	
	
}

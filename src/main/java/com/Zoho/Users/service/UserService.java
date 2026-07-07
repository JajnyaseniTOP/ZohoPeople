package com.Zoho.Users.service;

import com.Zoho.Users.dto.EmployeeBasicRequest;
import com.Zoho.Users.dto.EmployeeHierarchyRequest;
import com.Zoho.Users.dto.EmployeeRequest;
import com.Zoho.Users.dto.EmployeeWorkRequest;
import com.Zoho.Users.dto.LoginRequest;
import com.Zoho.Users.dto.UserProfile;
import com.Zoho.Users.model.Employee;
import com.Zoho.Users.model.EmployeeBasic;
import com.Zoho.Users.model.EmployeeHierarchy;
import com.Zoho.Users.model.EmployeeWork;
import com.Zoho.Users.model.User;

public interface UserService {

	boolean login(LoginRequest req);
	String getUserName(String userId);
	String getUserEmail(String userId);
	String getUserId(String userEmail);
	String getRole(String userEmail);
	UserProfile getSuperAdmin();
	Employee addEmployee(EmployeeRequest request);
	EmployeeWork addEmployeeWork(EmployeeWorkRequest request);

	User addUsers(User user);
	EmployeeBasic saveBasicInformation(EmployeeBasicRequest request);
	EmployeeHierarchy addEmployeeHierarchy(EmployeeHierarchyRequest request);
}

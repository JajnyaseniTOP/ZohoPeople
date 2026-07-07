package com.Zoho.Users.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Zoho.Users.dto.EmployeeBasicRequest;
import com.Zoho.Users.dto.EmployeeHierarchyRequest;
import com.Zoho.Users.dto.EmployeeRequest;
import com.Zoho.Users.dto.EmployeeWorkRequest;
import com.Zoho.Users.dto.LoginRequest;
import com.Zoho.Users.dto.LoginResponse;
import com.Zoho.Users.dto.UserProfile;
import com.Zoho.Users.model.Employee;
import com.Zoho.Users.model.EmployeeBasic;
import com.Zoho.Users.model.EmployeeHierarchy;
import com.Zoho.Users.model.EmployeeWork;
import com.Zoho.Users.model.User;
import com.Zoho.Users.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/User")
public class UserController {
	@Autowired
	public UserService service;
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest req){
		LoginResponse response = new LoginResponse();

		if(service.login(req)) {
			response.setSuccess(true);
			response.setMessage("Login Success");
			response.setUserName(service.getUserName(req.getUserEmailId()));
			response.setEmail(service.getUserEmail(req.getUserEmailId()));
			response.setUserId(service.getUserId(req.getUserEmailId()));
			response.setRole(service.getRole(req.getUserEmailId()));
			return response;
		}

		response.setSuccess(false);
		response.setMessage("Invalid Credentials");
		return response;
	}
	
	@GetMapping("/superAdmin")
	public UserProfile getSuperAdmin() {
		return service.getSuperAdmin();
	}

	@PostMapping("/addUsers")
	public User addUsers(@RequestBody User user) {
		User usr = service.addUsers(user);
		return usr;
		
	}
	
	
//	@PostMapping("/addEmployee")
//	public Employee addEmployee(@RequestBody Employee emp) {
//		Employee usr = service.addEmployee(emp);
//		return usr;
//		
//	}
	
	@PostMapping("/employee")
	public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeRequest request) {
	    Employee saved = service.addEmployee(request);
	    return ResponseEntity.ok(Map.of("message", "Employee added successfully", "employeeId", saved.getEmployeeId(),"employeeCode", saved.getEmployeeCode()));
	}


	
	@PostMapping("/employee/basic")
	public ResponseEntity<?> saveBasicInformation(@RequestBody EmployeeBasicRequest request){
	    service.saveBasicInformation(request);
	    return ResponseEntity.ok(Map.of("message","Employee Basic Information saved successfully",	"employeeCode",request.getEmployeeCode()));
	}

	
	  @PostMapping("/employee/work")
	  public ResponseEntity<?> addEmployeeWorks(@RequestBody EmployeeWorkRequest request) {
	      EmployeeWork savedWork = service.addEmployeeWork(request);
	      return ResponseEntity.ok(Map.of("message", "Employee Work Information saved successfully","employeeCode", request.getEmployeeCode()));      
	      
	  }
	  
	  
	  @PostMapping("/employee/hierarchy")
	  public ResponseEntity<?> addEmployeeHierarchy(@RequestBody EmployeeHierarchyRequest request) {
	      EmployeeHierarchy hierarchy =	 service.addEmployeeHierarchy(request);
	      return ResponseEntity.ok(Map.of("message", "Employee Hierarchy saved successfully","employeeCode", request.getEmployeeCode()));
	      
//json are listed on document file
	      
	  }
	  
	
}

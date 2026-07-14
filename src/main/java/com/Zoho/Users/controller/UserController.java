package com.Zoho.Users.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.Zoho.Users.dto.EmployeeRequest;
import com.Zoho.Users.dto.EmployeeSeparationRequest;
import com.Zoho.Users.dto.EmployeeWorkRequest;
import com.Zoho.Users.dto.LoginRequest;
import com.Zoho.Users.dto.LoginResponse;
import com.Zoho.Users.dto.NewHireResponse;
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
	public LoginResponse login(@RequestBody LoginRequest request){

	    return service.login(request);

	}
	
//	@GetMapping("/superAdmin")
//	public UserProfile getSuperAdmin() {
//		return service.getSuperAdmin();
//	}

	@PostMapping("/addUsers")
	public User addUsers(@RequestBody User user) {
		User usr = service.addUsers(user);
		return usr;		
	}
	
	

	
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
	  }	  
	  
	  @GetMapping("/employees/InternalReportingManager/dropdown")
	  public List<EmployeeDropdownResponse> getEmployeesForDropdown() {
	      return service.getAllEmployees();
	  }
	  
	  @PostMapping("/employee/identity")
	  public ResponseEntity<?> saveEmployeeIdentity( @RequestBody EmployeeIdentityRequest request) {
	      service.saveEmployeeIdentity(request);
	      return ResponseEntity.ok(Map.of("message", "Employee Identity Information saved successfully","employeeCode", request.getEmployeeCode()));
	  }
	  
	  @PostMapping("/employee/contact")
	  public ResponseEntity<?> saveEmployeeContact(@RequestBody EmployeeContactRequest request) {
	      service.saveEmployeeContact(request);
	      return ResponseEntity.ok(Map.of("message", "Employee Contact Information saved successfully","employeeCode", request.getEmployeeCode()));
	  }
	  
	  @PostMapping("/employee/separation")
	  public ResponseEntity<?> saveEmployeeSeparation( @RequestBody EmployeeSeparationRequest request) {
	      service.saveEmployeeSeparation(request);
	      return ResponseEntity.ok(Map.of("message", "Employee Separation Information saved successfully", "employeeCode", request.getEmployeeCode()));
	  }
	  
	  @PostMapping("/employee/dependent")
	  public ResponseEntity<?> saveEmployeeDependent(@RequestBody EmployeeDependentRequest request) {
	      service.saveEmployeeDependent(request);
	      return ResponseEntity.ok(Map.of( "message", "Employee Dependent Information saved successfully","employeeCode", request.getEmployeeCode()));
	  }
	  
	  @PostMapping("/employee/personal")
	  public ResponseEntity<?> saveEmployeePersonal(@RequestBody EmployeePersonalRequest request) {
	      service.saveEmployeePersonal(request);
	      return ResponseEntity.ok(Map.of("message", "Employee Personal Details saved successfully","employeeCode", request.getEmployeeCode()));
	  }
	  
	  @PostMapping("/employee/bank")
	  public ResponseEntity<?> saveEmployeeBank(@RequestBody EmployeeBankRequest request) {
	      service.saveEmployeeBank(request);
	      return ResponseEntity.ok(Map.of("message", "Employee Bank Details saved successfully", "employeeCode", request.getEmployeeCode()));
	  }
	  
	  @PostMapping("/employee/experience")
	  public ResponseEntity<?> addExperience(@RequestBody EmployeeExperienceRequest request){
	      service.addEmployeeExperience(request);
	      return ResponseEntity.ok(Map.of("message","Employee Experience Added Successfully","employeeCode",request.getEmployeeCode()));
	  }
	  
	  @GetMapping("/dashboard/new-hires")
	  public List<NewHireResponse> getNewHires() {
	      return service.getNewHires();
	  }
	
	
}

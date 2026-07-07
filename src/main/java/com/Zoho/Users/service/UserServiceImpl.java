package com.Zoho.Users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.Zoho.Users.repository.EmployeeBasicRepository;
import com.Zoho.Users.repository.EmployeeHierarchyRepository;
import com.Zoho.Users.repository.EmployeeRepository;
import com.Zoho.Users.repository.EmployeeWorkRepository;
import com.Zoho.Users.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserRepository userRepo;
	@Autowired
	public EmployeeRepository empRepo;	
	@Autowired
	public EmployeeBasicRepository employeeBasicRepository;
	
	@Autowired
	public EmployeeWorkRepository empworkRepo;
	
	@Autowired
	public EmployeeHierarchyRepository employeeHierarchyRepository;
	
	

	@Override
	public boolean login(LoginRequest req) {
	    // TEMP DEBUG — remove after diagnosing login
	    System.out.println("[LOGIN] received email=[" + req.getUserEmailId() + "] password=[" + req.getPassword() + "]");

	    User user = userRepo.findByEmail(req.getUserEmailId()).orElse(null);

        if (user == null) {
            System.out.println("[LOGIN] no user found for email=[" + req.getUserEmailId() + "]");
            return false;
        }

        System.out.println("[LOGIN] db password=[" + user.getPassword() + "] match=" + user.getPassword().equals(req.getPassword()));

        return user.getPassword().equals(req.getPassword());
	}

	@Override
	public String getUserName(String userEmail) {
		User user = userRepo.findByEmail(userEmail).orElse(null);
		return user != null ? user.getUsername() : "User";
	}

	@Override
	public String getUserEmail(String userEmail) {
		User user = userRepo.findByEmail(userEmail).orElse(null);
		return user != null ? user.getEmail() : "";
	}

	@Override
	public String getUserId(String userEmail) {
		User user = userRepo.findByEmail(userEmail).orElse(null);
		return user != null ? user.getUserId() : "";
	}

	@Override
	public String getRole(String userEmail) {
		User user = userRepo.findByEmail(userEmail).orElse(null);
		return user != null ? user.getRole() : "";
	}

	@Override
	public UserProfile getSuperAdmin() {
		User user = userRepo.findFirstByRoleIgnoreCase("super Administrator").orElse(null);
		if (user == null) {
			return null;
		}
		UserProfile profile = new UserProfile();
		profile.setUserId(user.getUserId());
		profile.setUserName(user.getUsername());
		profile.setEmail(user.getEmail());
		profile.setRole(user.getRole());
		return profile;
	}
	
	@Override
	public User addUsers(User user) {
		User usr =  userRepo.save(user);
		return usr;	
		
			
	}

	@Override
	public Employee addEmployee(EmployeeRequest request) {

	    Employee employee = new Employee();

	    employee.setEmployeeCode(request.getEmployeeCode());
	    employee.setFirstName(request.getFirstName());
	    employee.setLastName(request.getLastName());
	    employee.setEmail(request.getEmail());

	    return empRepo.save(employee);
	}
	

	
	
	@Override
	@Transactional
	public EmployeeBasic saveBasicInformation(EmployeeBasicRequest request) {

	    Employee employee = empRepo.findByEmployeeCode(request.getEmployeeCode());

	    if (employee == null) {
	        throw new RuntimeException("Employee not found");
	    }
	    
	    // Find Basic Information
	    EmployeeBasic basic = employeeBasicRepository.findByEmployee(employee);

	    if (basic == null) {
	        basic = new EmployeeBasic();
	        basic.setEmployee(employee);
	    }

	    basic.setPreferredName(request.getPreferredName());
	    basic.setFatherName(request.getFatherName());

	    return employeeBasicRepository.save(basic);
	}

	@Override
	public EmployeeWork addEmployeeWork(EmployeeWorkRequest request) {

	    Employee employee = empRepo.findByEmployeeCode(request.getEmployeeCode());

	    if (employee == null) {
	        throw new RuntimeException("Employee not found");
	    }

	    // Check if work information already exists
	    EmployeeWork work = empworkRepo.findByEmployee(employee);

	    // First time
	    if (work == null) {
	        work = new EmployeeWork();
	        work.setEmployee(employee);
	    }

	    // Update fields
	    work.setCompany(request.getCompany());
	    work.setDepartment(request.getDepartment());
	    work.setLocation(request.getLocation());
	    work.setDesignation(request.getDesignation());
	    work.setZohoRole(request.getZohoRole());
	    work.setEmploymentType(request.getEmploymentType());
	    work.setEmployeeStatus(request.getEmployeeStatus());
	    work.setCategory(request.getCategory());
	    work.setJoiningDate(request.getJoiningDate());
	    work.setCurrentExperience(request.getCurrentExperience());
	    work.setTotalExperience(request.getTotalExperience());
	    EmployeeWork empwork = empworkRepo.save(work);
	    return empwork;
	}

	@Override
	public EmployeeHierarchy addEmployeeHierarchy(EmployeeHierarchyRequest request) {

	    Employee employee = empRepo.findByEmployeeCode(request.getEmployeeCode());

	    if (employee == null) {
	        throw new RuntimeException("Employee not found");
	    }

	    EmployeeHierarchy hierarchy = employeeHierarchyRepository.findByEmployee(employee);

	    if (hierarchy == null) {
	        hierarchy = new EmployeeHierarchy();
	        hierarchy.setEmployee(employee);
	    }

	    hierarchy.setReportingManager(request.getReportingManager());
	    hierarchy.setOrganizationLevel(request.getOrganizationLevel());
	    hierarchy.setClientName(request.getClientName());
	    hierarchy.setClientReportingManager(request.getClientReportingManager());
	    hierarchy.setClientOnboardingDate(request.getClientOnboardingDate());

	    return employeeHierarchyRepository.save(hierarchy);
	}


	
	
	


}

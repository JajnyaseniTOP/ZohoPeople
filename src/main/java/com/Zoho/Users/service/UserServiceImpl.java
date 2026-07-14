package com.Zoho.Users.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.Zoho.Users.repository.EmployeeBankRepository;
import com.Zoho.Users.repository.EmployeeBasicRepository;
import com.Zoho.Users.repository.EmployeeContactRepository;
import com.Zoho.Users.repository.EmployeeDependentRepository;
import com.Zoho.Users.repository.EmployeeExperienceRepository;
import com.Zoho.Users.repository.EmployeeHierarchyRepository;
import com.Zoho.Users.repository.EmployeeIdentityRepository;
import com.Zoho.Users.repository.EmployeePersonalRepository;
import com.Zoho.Users.repository.EmployeeRepository;
import com.Zoho.Users.repository.EmployeeSeparationRepository;
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
	
	@Autowired
	public EmployeeIdentityRepository employeeIdentityRepo;
	
	@Autowired
	public EmployeeContactRepository employeeContactRepo;
	
	@Autowired
	private EmployeeSeparationRepository employeeSeparationRepo;
	
	@Autowired
	private EmployeeDependentRepository employeeDependentRepo;
	
	@Autowired
	private EmployeePersonalRepository employeePersonalRepo;
	
	@Autowired
	private EmployeeBankRepository employeeBankRepo;
	
	@Autowired
	private EmployeeExperienceRepository experienceRepo;
	
	
	@Override
	public LoginResponse login(LoginRequest request) {

	    LoginResponse response = new LoginResponse();

	    User user = userRepo.findByEmail(request.getUserEmailId());

	    if(user == null) {

	        response.setSuccess(false);
	        response.setMessage("Invalid Email");

	        return response;
	    }

	    if(!user.getPassword().equals(request.getPassword())) {

	        response.setSuccess(false);
	        response.setMessage("Invalid Password");

	        return response;
	    }

	    Employee employee = user.getEmployee();

	    EmployeeWork work = empworkRepo.findByEmployee(employee);

	    response.setSuccess(true);
	    response.setMessage("Login Successful");

	    response.setEmployeeCode(employee.getEmployeeCode());

	    response.setEmployeeName(
	            employee.getFirstName() + " " + employee.getLastName());

	    if(work != null) {
	        response.setRole(work.getZohoRole());
	    }

	    return response;

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

	@Override
	public List<EmployeeDropdownResponse> getAllEmployees() {

	    List<Employee> employees = empRepo.findAll();

	    List<EmployeeDropdownResponse> response = new ArrayList<>();

	    for (Employee emp : employees) {

	        EmployeeDropdownResponse dto = new EmployeeDropdownResponse();

	        dto.setEmployeeCode(emp.getEmployeeCode());

	        dto.setEmployeeName(emp.getFirstName() + " " + emp.getLastName());

	        response.add(dto);
	    }

	    return response;
	}

	
	@Override
	public EmployeeIdentity saveEmployeeIdentity(EmployeeIdentityRequest request) {
	    Employee employee = empRepo.findByEmployeeCode(request.getEmployeeCode());
	    if (employee == null) {
	        throw new RuntimeException("Employee not found");
	    }
	    EmployeeIdentity identity = employeeIdentityRepo.findByEmployee(employee);
	    if (identity == null) {
	        identity = new EmployeeIdentity();
	        identity.setEmployee(employee);
	    }
	    identity.setPan(request.getPan());
	    identity.setAadhar(request.getAadhar());
	    identity.setUan(request.getUan());
	    return employeeIdentityRepo.save(identity);
	}
	
	
	@Override
	public EmployeeContact saveEmployeeContact(EmployeeContactRequest request) {

	    Employee employee = empRepo.findByEmployeeCode(request.getEmployeeCode());

	    if (employee == null) {
	        throw new RuntimeException("Employee not found");
	    }

	    EmployeeContact contact = employeeContactRepo.findByEmployee(employee);

	    if (contact == null) {
	        contact = new EmployeeContact();
	        contact.setEmployee(employee);
	    }

	    contact.setWorkPhoneNumber(request.getWorkPhoneNumber());
	    contact.setEmergencyContactNumber(request.getEmergencyContactNumber());
	    contact.setExtension(request.getExtension());
	    contact.setSeatingLocation(request.getSeatingLocation());
	    contact.setTags(request.getTags());
	    contact.setPresentAddress(request.getPresentAddress());
	    contact.setPermanentAddress(request.getPermanentAddress());	   
	    contact.setPersonalMobileNumber(request.getPersonalMobileNumber());
	    contact.setAlternateContactNumber(request.getAlternateContactNumber());
	    contact.setBloodGroup(request.getBloodGroup());
	    contact.setPersonalEmailAddress(request.getPersonalEmailAddress());

	    return employeeContactRepo.save(contact);
	}
	
	
	@Override
	public EmployeeSeparation saveEmployeeSeparation(EmployeeSeparationRequest request) {

	    Employee employee = empRepo.findByEmployeeCode(request.getEmployeeCode());

	    if (employee == null) {
	        throw new RuntimeException("Employee not found");
	    }

	  
		EmployeeSeparation separation =	 employeeSeparationRepo.findByEmployee(employee);

	    if (separation == null) {
	        separation = new EmployeeSeparation();
	        separation.setEmployee(employee);
	    }

	    separation.setDateOfExit(request.getDateOfExit());
	    separation.setLastWorkingDate(request.getLastWorkingDate());

	    return employeeSeparationRepo.save(separation);
	}

	
	
	@Override
	public EmployeeDependent saveEmployeeDependent(EmployeeDependentRequest request) {

	    Employee employee = empRepo.findByEmployeeCode(request.getEmployeeCode());

	    if (employee == null) {
	        throw new RuntimeException("Employee not found");
	    }

	    EmployeeDependent dependent = employeeDependentRepo.findByEmployee(employee);

	    if (dependent == null) {
	        dependent = new EmployeeDependent();
	        dependent.setEmployee(employee);
	    }

	    dependent.setDependentName(request.getDependentName());
	    dependent.setRelationship(request.getRelationship());
	    dependent.setDob(request.getDob());

	    return employeeDependentRepo.save(dependent);
	}
	
	
	@Override
	public EmployeePersonal saveEmployeePersonal(EmployeePersonalRequest request) {

	    Employee employee = empRepo.findByEmployeeCode(request.getEmployeeCode());

	    if (employee == null) {
	        throw new RuntimeException("Employee not found");
	    }

	    EmployeePersonal personal = employeePersonalRepo.findByEmployee(employee);

	    if (personal == null) {
	        personal = new EmployeePersonal();
	        personal.setEmployee(employee);
	    }

	    personal.setDateOfBirth(request.getDateOfBirth());
	    personal.setAge(request.getAge());
	    personal.setGender(request.getGender());
	    personal.setMaritalStatus(request.getMaritalStatus());
	    personal.setAboutMe(request.getAboutMe());
	    personal.setExpertise(request.getExpertise());

	    return employeePersonalRepo.save(personal);
	}

	
	@Override
	public EmployeeBank saveEmployeeBank(EmployeeBankRequest request) {

	    Employee employee = empRepo.findByEmployeeCode(request.getEmployeeCode());

	    if (employee == null) {
	        throw new RuntimeException("Employee not found");
	    }

	    EmployeeBank bank = employeeBankRepo.findByEmployee(employee);

	    if (bank == null) {
	        bank = new EmployeeBank();
	        bank.setEmployee(employee);
	    }

	    bank.setBankName(request.getBankName());
	    bank.setAccountNumber(request.getAccountNumber());
	    bank.setIfscCode(request.getIfscCode());
	    bank.setBankAddress(request.getBankAddress());

	    return employeeBankRepo.save(bank);
	}
	
	


	@Override
	public EmployeeExperience addEmployeeExperience(EmployeeExperienceRequest request) {
	    Employee employee = empRepo.findByEmployeeCode(request.getEmployeeCode());
	    if(employee == null) {
	        throw new RuntimeException("Employee not found");
	    }
	    EmployeeExperience experience = new EmployeeExperience();
	    experience.setEmployee(employee);
	    experience.setCompanyName(request.getCompanyName());
	    experience.setJobTitle(request.getJobTitle());
	    experience.setFromDate(request.getFromDate());
	    experience.setToDate(request.getToDate());
	    experience.setJobDescription(request.getJobDescription());
	    experience.setRelevant(request.getRelevant());
	    return experienceRepo.save(experience);
	}
	
	
	@Override
	public List<NewHireResponse> getNewHires() {	 
	    LocalDate date = LocalDate.now().minusDays(15);
	    List<EmployeeWork> workList = empworkRepo.findByJoiningDateGreaterThanEqual(date);
	    List<NewHireResponse> response = new ArrayList<>();
	    for (EmployeeWork work : workList) {
	        Employee employee = work.getEmployee();
	        NewHireResponse dto = new NewHireResponse();
	        dto.setEmployeeCode(employee.getEmployeeCode());
	        dto.setEmployeeName(employee.getFirstName() + " " + employee.getLastName());
	        dto.setEmail(employee.getEmail());
	        response.add(dto);
	    }
	    return response;
	}





//	@Override
//	public UserProfile getSuperAdmin() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

}

package com.Zoho.Users.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {	
	
	@Id
    private String userId;   //TOP083
	
	private String firstname;
	
	private String lastname;

    private String username;

    private String email;

    private String password;

    private String role;    
    

    
    @PrePersist
    @PreUpdate
    public void generateUsername() {
    	   String first = firstname != null ? firstname.trim() : "";
    	   String last = lastname != null ? lastname.trim() : "";

    	    if (last.isEmpty()) {
    	        this.username = first;
    	    } else {
    	        this.username = first + " " + last;
    	    }
    }
    
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

}

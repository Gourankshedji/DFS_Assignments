package com.cg.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity   //Declare the class a entity
@Table(name="employees")   //Declare the table name

public class Employee {
	
	@Id
	@GeneratedValue    // generates an automatic value during commit for every new entity
	private int employeeId;
	
	@NotEmpty(message="employee name is required")
	private String employeeName;
	
	@NotEmpty(message="Employee contact is required")
	@Pattern(regexp = "\\d{10}", message ="Contact number is Invalid")	
	private String employeeContact;
	
	@NotEmpty(message="Employee profile is required")
	private String employeeProfile;
	

	//default constructor
	public Employee() {
		super();
	}

	
	//constructor without id
	public Employee(String employeeName, String employeeContact, String employeeProfile) {
		super();
		this.employeeName = employeeName;
		this.employeeContact = employeeContact;
		this.employeeProfile = employeeProfile;
	}

	
	//constructor with id
	public Employee(int employeeId, String employeeName, String employeeContact, String employeeProfile) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeContact = employeeContact;
		this.employeeProfile = employeeProfile;
	}

	
	//getters and setters methods
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeContact() {
		return employeeContact;
	}

	public void setEmployeeContact(String employeeContact) {
		this.employeeContact = employeeContact;
	}

	public String getEmployeeProfile() {
		return employeeProfile;
	}

	public void setEmployeeProfile(String employeeProfile) {
		this.employeeProfile = employeeProfile;
	}

	

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeContact="
				+ employeeContact + ", employeeProfile=" + employeeProfile + "]";
	}


	public Employee orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

package com.cg.service;


import java.util.List;

import javax.validation.Valid;

import com.cg.entities.Employee;
import com.cg.exception.EmployeeException;

public interface IEmployeeService {

	Employee addEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	void removeEmployee(int employeeId);
	Employee getEmployee(int employeeId);
	public List<Employee> getEmployee() throws EmployeeException;


}

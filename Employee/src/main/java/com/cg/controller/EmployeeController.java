package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Employee;
import com.cg.exception.EmployeeException;
import com.cg.service.IEmployeeService;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/employee/employees")
public class EmployeeController {
	
	@Autowired
	IEmployeeService service;
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	// Method to add employee 
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
		Employee employeeData = service.addEmployee(employee);
		if (employeeData == null) {
			logger.error("Controller: Failed to add employee");
			throw new EmployeeException("employee not added");
		}
		logger.info("*** Controller : Employee added successfully. ***");
		return new ResponseEntity<Employee>(employeeData, HttpStatus.OK);
	}
	
	
	// Method to update employee details with Id
	@PutMapping("/updateEmployee/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee) {
		Employee employeeData = service.updateEmployee(employee);
		if (employeeData == null) {
			logger.error("Controller: Failed to update employee");
			throw new EmployeeException("Employee not updated");
		}
		logger.info("*** Controller : Employee updated successfully. ***");
		return new ResponseEntity<Employee>(employeeData, HttpStatus.OK);
	}

		
	//Method to remove employee details with Id
	@DeleteMapping("/removeEmployee/{employeeId}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable int employeeId){
		logger.warn("Controller: Removing Employee");
		service.removeEmployee(employeeId);
		if ( service.getEmployee(employeeId) == null) {
			logger.info("*** Controller : Employee removed. ***");
			return new ResponseEntity<Object>("Employee deleted successfully", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Employee Not deleted successfully", HttpStatus.OK);
	}
		
		
	// Method to get Employee by id
	@GetMapping("/getEmployee/{employeeId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
		Employee employeeData = service.getEmployee(employeeId);
		if (employeeData == null) {
			logger.error("Controller: Employee Not Found For given id : " + employeeId);
			throw new EmployeeException("No Employee present with the given id " + employeeId);
		}
		logger.info("*** Controller : Displaying Employee ***");
		return new ResponseEntity<Employee>(employeeData, HttpStatus.OK);
	}
	@GetMapping("/selectAll")
	public ResponseEntity<Object> selectAllEmployee() {
		logger.debug("AppointmentController is executing view Appointment ");

		List<Employee> employeeList;
		try {
			employeeList = service.getEmployee();
			return new ResponseEntity<Object>(employeeList, HttpStatus.OK);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return new ResponseEntity<Object>("No Appointments found in DataBase", HttpStatus.NO_CONTENT);
	}
}

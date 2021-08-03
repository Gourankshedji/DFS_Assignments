package com.cg.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entities.Employee;
import com.cg.exception.EmployeeException;
import com.cg.service.IEmployeeService;
import com.cg.repository.IEmployeeRepository;


@Service
@Transactional
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	IEmployeeRepository repository;
	
	Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	
	//Method to add Employee
	@Override
	public Employee addEmployee(Employee employee) {
		Employee employeeData = repository.save(employee);
		logger.info("*** Service :  Employee added successfully. ***");
		return employeeData;
	}

	//Method to update employee using id
	@Override
	public Employee updateEmployee(Employee employee) {
		Employee employeeData = repository.findById(employee.getEmployeeId());
		if(employeeData!=null)
		{
			employeeData.setEmployeeName(employee.getEmployeeName());
			employeeData.setEmployeeContact(employee.getEmployeeContact());
			employeeData.setEmployeeProfile(employee.getEmployeeProfile());
			logger.info("*** Service : Employee updated successfully. ***");
			return repository.save(employeeData);
		}
		else
		{
			logger.error("*** Service : Employee updated Failed. ***");
			return null;
		}
	}
	
	
	//Method to remove employee using id
	@Override
	public void removeEmployee(int employeeId) {
		//Employee employeeData = repository.findById(employeeId);
		logger.warn("*** Removing Employee. ***");
		if (repository.existsById(employeeId)) {
			repository.deleteById(employeeId);
			logger.info("*** Service : User removed. ***");
		}
		//return employeeData;
	}

	
	//Method to view employee using id
	@Override
	public Employee getEmployee(int employeeId) {
		if (repository.existsById(employeeId)) {
			logger.info("*** Service : Displaying Employee with id ***" + employeeId);
		}
		return repository.findById(employeeId);
	}
	@Override
	public List<Employee> getEmployee() throws EmployeeException {
		logger.debug("Appointment Service is implementing view appointment method");

		List<Employee> employeeList = repository.findAll();
		if(employeeList.isEmpty()){
			logger.error("Em[ployeeException thrown");

			throw new EmployeeException("Appointments Database is empty");
		}
		else
			logger.info(" Appointment List Displayed");

			return employeeList;	}

	
}

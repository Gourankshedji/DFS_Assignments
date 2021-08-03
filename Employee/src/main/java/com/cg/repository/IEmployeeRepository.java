package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entities.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee save(Employee employee);
	boolean existsById(int employeeId);
	void deleteById(int employeeId);
	Employee findById(int employeeId);

}

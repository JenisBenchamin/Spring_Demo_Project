package com.gl.service;

import java.util.List;

import com.gl.model.Employee;

public interface EmployeeDAO {

	public List<Employee> getAllEmployee();
	
	public Employee addEmployee(Employee emp);
}

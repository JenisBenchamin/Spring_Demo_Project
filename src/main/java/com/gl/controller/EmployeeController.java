package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.model.Employee;
import com.gl.service.EmployeeDAO;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	public EmployeeDAO empDAO;
	
	@GetMapping("/getAll")
	public ResponseEntity<?>getAllEmployee(){
		List<Employee>empList = empDAO.getAllEmployee();
		if (empList!=null) {
			return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Employee List is empty",HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(value="/addEmp",consumes="application/json; characterset=uft-8")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp) {
		if (empDAO.addEmployee(emp)!=null) {
			return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Sorry cannot enter the data",HttpStatus.CONFLICT);
	}
	
	
}

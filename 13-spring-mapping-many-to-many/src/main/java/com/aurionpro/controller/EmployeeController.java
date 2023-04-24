package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Employee;
import com.aurionpro.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(value = { "/getEmployees", "/{empId}" })
	public List<Employee> getEmployee(@PathVariable(required = false) Long empId) {
		return employeeService.getEmployeeDetails(empId);
	}

	@DeleteMapping("delete/{empId}")
	public ResponseEntity removeEmployee(@PathVariable Long empId ) {
	employeeService.deleteEmployee(empId);
	return new ResponseEntity(HttpStatus.OK);
}
}

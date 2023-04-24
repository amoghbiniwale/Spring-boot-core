package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.Employee;

public interface EmployeeService {

	void saveEmployee(Employee employee);

	List<Employee> getEmployeeDetails(Long empId);

	void deleteEmployee(Long empId);

}

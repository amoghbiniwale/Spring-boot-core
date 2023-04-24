package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aurionpro.entity.Employee;
import com.aurionpro.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployeeDetails(Long empId) {
		if (null != empId) {
			return employeeRepository.findAllEmpById(empId);
		} else {
			return employeeRepository.findAll();
		}
	}

	@Override
	public void deleteEmployee(Long empId) {
		employeeRepository.deleteById(empId);
	}

}

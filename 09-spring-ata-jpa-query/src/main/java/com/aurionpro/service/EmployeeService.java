package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.Employee;

public interface EmployeeService {

	List<Employee> findAllEmployees();

	List<Employee> addEmployees(List<Employee> employees);

	List<Employee> findEmployeeByActiveState(Boolean activeState);

	List<Employee> findEmployeeByDesignation(List<String> roles);

	List<Employee> findEmployeeWithDesignationAndActiveState(String roles, Boolean activeState);

	List<Employee> findEmployeesWithSalary(int count);

	List<Employee> findEmployeesByNames(String names);

	List<Employee> findEmployeesHavingSalaryLessthan500(Boolean activeState);

	List<Employee> findEmployeesByNameList(List<String> names);

	//List<Employee> getAllEmployees();

	

}

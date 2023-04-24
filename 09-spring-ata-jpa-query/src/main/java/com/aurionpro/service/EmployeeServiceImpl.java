package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Employee;
import com.aurionpro.repository.EmployeeRepsitory;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepsitory repository;
	

	public List<Employee> findAllEmployees() {
		return repository.findAllEmployees();
	}

	@Override
	public List<Employee> addEmployees(List<Employee> employees) {
		return repository.saveAll(employees);
	}

	@Override
	public List<Employee> findEmployeeByActiveState(Boolean activeState) {
		return repository.findEmployeeByActiveState(activeState);
	}

	@Override
	public List<Employee> findEmployeeByDesignation(List<String> roles) {
		 return repository.findEmployeeByDesignation(roles);
	}

	@Override
	public List<Employee> findEmployeeWithDesignationAndActiveState(String roles, Boolean activeState) {
		return repository.findEmployeeWithDesignationAndActiveState(roles,activeState);
	}

	@Override
	public List<Employee> findEmployeesWithSalary(int count) {
		return repository.findEmployeesWithSalary(count);
	}


	@Override
	public List<Employee> findEmployeesByNameList(List<String> names) {
		return repository.findEmployeesByNameList(names);
	}

//	@Override
//	public List<Employee> getAllEmployees() {
//		return repository.getAllEmployees();
//	}

	@Override
	public List<Employee> findEmployeesHavingSalaryLessthan500(Boolean activeState) {
		return repository.findEmployeesHavingSalaryLessthan500(activeState);
	}

@Override
public List<Employee> findEmployeesByNames(String names) {
	// TODO Auto-generated method stub
	return null;
}



//	@Override
//	public List<Employee> findEmployeesByNameList(List<String> names) {
//		return repository;
//	}

}

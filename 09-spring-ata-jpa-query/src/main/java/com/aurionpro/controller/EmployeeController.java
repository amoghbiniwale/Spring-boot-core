package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Employee;
import com.aurionpro.service.EmployeeService;

@RestController
@RequestMapping("/empapp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List <Employee> findAllEmployee(){
		return employeeService.findAllEmployees();
		
	}
	
	@GetMapping("/employees/active/{activeState}")
	public List<Employee>findEmployeeByActiveState(@PathVariable Boolean activeState){
		return employeeService.findEmployeeByActiveState(activeState);
	}
	
	@GetMapping("/employees/designation")
	public List<Employee>findEmployeeByDesignation(@RequestParam List<String> roles){
		return employeeService.findEmployeeByDesignation(roles);
	}
	
	
	@PostMapping("/employees")
	public List<Employee>addMultipleEmployee(@RequestBody List<Employee> employees){
		return employeeService.addEmployees(employees);
	}
	
	@GetMapping("/employees/designationAndActiveState")
	public List<Employee>findEmployeeWithDesignationAndActiveState(@RequestParam String roles ,@RequestParam Boolean activeState){
		return employeeService.findEmployeeWithDesignationAndActiveState(roles,activeState);
	}
	
	
	@GetMapping("/employees/name/{name}")
	public List<Employee> findEmployeesByName(@PathVariable String names){
		return employeeService.findEmployeesByNames(names);		
	}
	
	@GetMapping("/employees/nameList")
	public List<Employee> findEmployeesByNameList(@RequestParam List<String> names) {
		return employeeService.findEmployeesByNameList(names);
	}
	
//	//Named query
//		@GetMapping("/employis")
//		public List<Employee> getAllEmployees(){
//			return employeeService.getAllEmployees();
//		}
	
	@GetMapping("/employees/salary/active/{salary}")
	public List<Employee> findEmployeesHavingSalaryLessthan500(@PathVariable Boolean activeState){
		return employeeService.findEmployeesHavingSalaryLessthan500(activeState);
	}
	
	
	@GetMapping("/employees/topsalary/{count}")
	public List<Employee> findEmployeesHavingSalary(@PathVariable int count){
		return employeeService.findEmployeesWithSalary(count);
	}	
	
}

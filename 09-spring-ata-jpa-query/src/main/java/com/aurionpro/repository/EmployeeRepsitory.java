package com.aurionpro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aurionpro.entity.Employee;

public interface EmployeeRepsitory extends JpaRepository<Employee, Integer> {
	@Query("select e from Employee e")
	List<Employee> findAllEmployees();

	@Query("select e from Employee e where e.active =?1")
	List<Employee> findEmployeeByActiveState(Boolean activeState);

	@Query("select e from Employee e where e.designation in ?1")
	List<Employee> findEmployeeByDesignation(List<String> roles);

	// find emp with designation and active state
	// select e from Employee where e.designation in ?1 and e.active =?2
	//
	@Query("select e from Employee e where e.designation=:theDesignation and e.active=:theActive")
	List<Employee> findEmployeeWithDesignationAndActiveState(@Param("theDesignation") String designation,
			@Param("theActive") Boolean activeState);

	// find top 3 salary of emp
	@Query("select e from Employee e order by e.salary desc limit ?1")
	List<Employee> findEmployeesWithSalary(int count);

	// find emp by name -> List
	// select e from Employee e where e.name =:theName
	@Query("select e from Employee e where e.name in ?1")
	List<Employee> findEmployeesByNameList(List<String> names);

	// find emp with salary less than 5000 and active
	@Query("select e from Employee e where e.salary<='50000' and e.active=:theActive")
	List<Employee> findEmployeesHavingSalaryLessthan500(@Param("theActive") Boolean activeState);

	
	
//	@Query("select e from Employee e where e.name in ?1")
//	List<Employee> findEmployeesByNameList();
//
	
////	//named query
////		List<Employee> getAllEmployees();

}

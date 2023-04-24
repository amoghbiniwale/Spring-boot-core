package com.aurionpro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	List<Employee> save(Long empId);

	List<Employee> findAllEmpById(Long empId);

}

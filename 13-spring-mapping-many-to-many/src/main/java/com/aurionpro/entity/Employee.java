package com.aurionpro.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	private String empName;
	
	@ManyToMany
	@JoinTable(name = "employee_project",
		joinColumns = @JoinColumn (name = "employee_id"),
		inverseJoinColumns  = @JoinColumn(name = "project_id")
	)
	private Set<Project>assignProjects = new HashSet<>();
	
} 

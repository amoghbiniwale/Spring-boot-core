package com.aurionpro.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="PROJECT")
public class Project {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long projectId;
	private String projectName;
	
	
	@ManyToMany(mappedBy = "assignProjects")
	private Set<Employee> employeeSet = new HashSet<>();
}



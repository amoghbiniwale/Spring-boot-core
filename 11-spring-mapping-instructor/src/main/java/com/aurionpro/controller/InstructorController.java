package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Instructor;
import com.aurionpro.repository.InstructorRepository;
import com.aurionpro.service.InstructorService;

@RestController
public class InstructorController {
	@Autowired
	private InstructorService instructorService ;
	
	@PostMapping("/saveInstructor")
	public ResponseEntity<String> saveInstructor(@RequestBody List<Instructor> insData){
		instructorService.saveInstructor(insData);
		return ResponseEntity.ok("Data saved");
	}
}

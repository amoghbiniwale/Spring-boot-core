package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Instructor;
import com.aurionpro.repository.InstructorRepository;
import com.aurionpro.service.InstructorService;

@Service
public class InstructorServiceImpl implements InstructorService{
	
	@Autowired
	private InstructorRepository instructorRepository ;

	@Override
	public List<Instructor> saveInstructor(List<Instructor> insData) {
		return instructorRepository.saveAll(insData);
	}	

}

package com.aurionpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Student;
import com.aurionpro.repository.StudentRepository;
import com.aurionpro.service.StudentService;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("studentapp") // to access controller http://localhost:8080/studentapp
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/students")
	public List<Student> findAllStudents() {
		return service.findAllStudent();
	}

	@GetMapping("/students/{sid}")
	public Student findStudent(@PathVariable(name = "sid") int id) {
		return service.findStudentByID(id);
	}

	@PostMapping("/students")

	public Student saveStudent(@RequestBody Student student) {
		student.setId(0);
		return service.saveStudent(student);

	}

	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {

		return service.updateStudent(student);
	}

	@DeleteMapping("/students/{stuId}")
	private void deleteStudentById(@PathVariable(name = "stuId") int id) {
		service.deleteStudentById(id);
	}

	@DeleteMapping("/students")
	private void deleteAllStudents() {
		service.deleteAll();

	}
}

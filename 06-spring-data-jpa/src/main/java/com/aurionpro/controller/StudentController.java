package com.aurionpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Student;
import com.aurionpro.exception.NotFoundException;
import com.aurionpro.exception.StudentErrorResponse;
import com.aurionpro.exception.StudentNotFoundException;
import com.aurionpro.repository.StudentRepository;
import com.aurionpro.service.StudentService;

import aj.org.objectweb.asm.Handle;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("studentapp") // to access controller http://localhost:8080/studentapp
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/students")
	public ResponseEntity<List<Student>> findAllStudents() {
		List<Student> findAllStudent = service.findAll();
		return new ResponseEntity<>(findAllStudent, HttpStatus.CREATED);
	}

	@GetMapping("/students/{sid}")
	public ResponseEntity<Student> findById(@PathVariable(name = "sid") int id) {
		Student studentId = service.findById(id);
		return new ResponseEntity<>(studentId, HttpStatus.CREATED);

	}

	@PostMapping("/students")

	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		student.setId(0);
		Student saveStudent = service.save(student);
		return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);

	}

	@PutMapping("/students")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		Student update = service.save(student);
		return new ResponseEntity<>(update, HttpStatus.CREATED);
	}

	@DeleteMapping("/students/{stuId}")
	private ResponseEntity<?> deleteStudentById(@PathVariable(name = "stuId") int id) {
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@PostMapping("/stuents/all")
	public List<Student> saveAllStudents(@RequestBody List<Student> studentList) {
		return service.saveAll(studentList);
	}

	@RequestMapping(value = "/pagingAndShortingStudent/{pageNumber}/{pageSize}", method = RequestMethod.GET)
	public Page<Student> studentPagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
		return service.getStudentPagination(pageNumber, pageSize);

	}

}

//
////@DeleteMapping("/students")
////private void deleteAllStudents() {
////service.deleteAll();
////
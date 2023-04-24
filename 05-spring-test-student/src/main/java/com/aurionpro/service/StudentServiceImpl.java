package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.aurionpro.entity.Student;
import com.aurionpro.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public List<Student> findAllStudent() {

		return repository.findAllStudents();
	}

	@Override
	public Student findStudentByID(int id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Student saveStudent(Student student) {
		return repository.saveStudent(student);
	}
	
	@PostMapping("/students")
	@Transactional
	public Student updateStudent(@RequestBody Student student) {
		return repository.saveStudent(student);
	
}

	@Override
	@Transactional
	public void deleteStudentById(int id) {
		repository.deleteStudentById(id);
		
	}

	@Override
	@Transactional
	public void deleteAll() {
		repository.deleteAll();
		
	}

	

}

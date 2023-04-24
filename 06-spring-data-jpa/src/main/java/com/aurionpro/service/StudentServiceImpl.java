package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.aurionpro.entity.Student;
import com.aurionpro.exception.NotFoundException;
import com.aurionpro.exception.StudentNotFoundException;
import com.aurionpro.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public List<Student> findAll() {
		List<Student> listStudent = repository.findAll();
		if (listStudent.size() == 0) {
			throw new NotFoundException("student mot found");
		}

		return repository.findAll();
	}

	@Override
	public Student findById(int id) {
		List<Student> listStudent = repository.findAll();
		boolean flag = false;
		for (Student x : listStudent) {
			if (x.getId() == id) {
				flag = true;
				break;
			}

		}
		if (flag) {
			return repository.findById(id).get();
		} else {
			throw new StudentNotFoundException("student with id " + id + "not found");
		}

	}

	@Override
	@Transactional
	public Student save(Student student) {
		return repository.save(student);
	}

	@PostMapping("/students")
	@Transactional
	public Student updateStudent(@RequestBody Student student) {
		return repository.save(student);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		repository.deleteById(id);

	}

	@Override
	@Transactional
	public void deleteAll() {
		repository.deleteAll();

	}

	@Override
	public List<Student> saveAll(List<Student> studentList) {
		return repository.saveAll(studentList);
	}

	@Override
	public Page<Student> getStudentPagination(Integer pageNumber , Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return repository.findAll(pageable);
	}
}

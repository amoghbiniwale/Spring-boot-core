package com.aurionpro.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.aurionpro.entity.Course;
import com.aurionpro.entity.Instructor;
import com.aurionpro.entity.Instructor_details;
import com.aurionpro.repositoy.CourseRepository;
import com.aurionpro.repositoy.InstructorRepository;
import com.aurionpro.repositoy.Instructor_detailsRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorRepository instructorRepository;
	
	@Autowired
	private Instructor_detailsRepository instructor_detailsRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public ResponseEntity<String> saveInstructor(List<Instructor> data) {
		instructorRepository.saveAll(data);
		return ResponseEntity.ok("Data saved");
	}

	@Override
	public Instructor updateInstructor(Long instructor_id, Long detail_id) {
		Instructor instructor = instructorRepository.findById(instructor_id).get();
		Instructor_details instructorDetail = instructor_detailsRepository.findById(detail_id).get();
		instructor.setDetails(instructorDetail);
		instructorRepository.save(instructor);
		return instructor;
	}

	@Override
	public ResponseEntity<String> deleteInstructor(Long id) {
		instructorRepository.deleteById(id);
		return ResponseEntity.ok("Data deleted");
	}

	@Override
	public Instructor updateCourse(Long instructor_id, Long course_id) {
		Instructor instructor = instructorRepository.findById(instructor_id).get();
		Set<Course> courses= instructor.getCourses();
		Course course = courseRepository.findById(course_id).get();
		courses.add(course);
		instructor.setCourses(courses);
		instructorRepository.save(instructor);
		return instructor;
	}

	@Override
	public Set<Course> showCourse(Long instructor_id) {
		Instructor instructor = instructorRepository.findById(instructor_id).get();
		Set<Course> course = instructor.getCourses();
		return course;
	}

	@Override
	public Instructor getInstructorByCourse(Long course_id) {
		Course course = courseRepository.findById(course_id).get();
		Instructor instructor = course.getInstructor();
		return instructor;
	}

	
	
}
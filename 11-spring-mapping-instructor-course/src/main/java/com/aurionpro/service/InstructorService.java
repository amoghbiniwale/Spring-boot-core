package com.aurionpro.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.aurionpro.entity.Course;
import com.aurionpro.entity.Instructor;

public interface InstructorService {

	ResponseEntity<String> saveInstructor(List<Instructor> data);

	Instructor updateInstructor(Long instructor_id, Long detail_id);

	ResponseEntity<String> deleteInstructor(Long id);

	Instructor updateCourse(Long instructor_id, Long course_id);

	Set<Course> showCourse(Long instructor_id);

	Instructor getInstructorByCourse(Long course_id);

}

package com.aurionpro.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
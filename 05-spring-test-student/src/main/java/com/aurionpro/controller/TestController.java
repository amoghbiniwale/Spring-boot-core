package com.aurionpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("test") //to access controller http://localhost:8080/studentapp
public class TestController {
	
	List<Student> studentList;
	@PostConstruct    //use after constructor
	public void init() {
		studentList = new ArrayList<Student>();
		studentList.add(new Student(1,"amogh","biniwale","amogh10@gmail.com"));
		studentList.add(new Student(2,"man","pale","amogh10@gmail.com"));
		studentList.add(new Student(3,"ram","kale","amogh10@gmail.com"));
		studentList.add(new Student(4,"sham","mali","amogh10@gmail.com"));
		
	}
	
	@GetMapping("/students") ////http://localhost:8080/studentapp/students  itwill covert into json format by jackson lib
	public List<Student>findAllStudents(){
		return studentList;
		
	}
	
	@GetMapping("/students/{studId}") //  http://localhost:8080/studentapp/students/1
	public Student findStudentbyId(@PathVariable(name = "studId")int id){
		//return studentList.get(id);
		for(Student x:studentList) {
			if(x.getId()==id) {
				return x;
			}
		}
		
		return null;
	}
	
//	
//	@GetMapping("/hello") //http://localhost:8080/studentapp/hello
//	public String greeting() {
//		return "hello all";
//		
//	}
//	
//	@GetMapping("/welcome") //http://localhost:8080/studentapp/welcome
//	public String welcome() {
//		return "welcome all";
	
	
}

package com.aurionpro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aurionpro.dao.StudentDao;
import com.aurionpro.entity.Student;



@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	StudentDao studentDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 addNewStudent();
//		
//		Student student = findStudentById(5);
//		System.out.println(student);
//		
//		
//	}
//	
//	
//	find by id studnet
//	private Student findStudentById(int id) {
//		return studentDao.findById(id);
//		
		//find all student
//		List<Student>students=findAllStudnet();
//		System.out.println(students);
		
		//find by name
//		List<Student>students=findByFirstName("amogh");
//		System.out.println(students);
		
		
//		//findByemail
//		List<Student>students=findByEmail("sankalp@gmail.com");
//		System.out.println(students);
		
		//update Student
//		updateStudent(5);
		
		//delete by id
//		deleteStudent(12);
		
		//delete all
		//deleteAllStudent();
		
	}

	private void deleteAllStudent() {
		studentDao.deleteAll();
	}

	private void deleteStudent(int id) {
		studentDao.detelteStudent(id);
	}

	private void updateStudent(int id) {
			Student student = new Student(5,"Anand","kokne","anand@gmail.com");
			studentDao.update(student);
	}

	private List<Student> findByEmail(String email) {
		return studentDao.findByEmail(email);
	}

	private List<Student> findByFirstName(String firstName) {
		return studentDao.findFirstName(firstName);
	}

	private List<Student> findAllStudnet() {
		return studentDao.findAll();
	}

	private void addNewStudent() {
		Student student = new Student("amogh","biniwale","amogh@gmail.com");
		Student resultStudent = studentDao.save(student);
		System.out.println(resultStudent);
	}

		
}

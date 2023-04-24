package com.aurionpro.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aurionpro.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository 
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private EntityManager manager;
	
	@Override
	@Transactional
	public Student save(Student student) {
		 manager.persist(student);  //prsist is use to save obj in db
		 return manager.find(Student.class , student.getId());
	}

	@Override
	public Student findById(int id) {
		return manager.find(Student.class ,id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query = manager.createQuery("select e from Student e",Student.class); //e for allise to get entity from class.. to get just name e.firstName
		return query.getResultList();
		 
	}

	@Override
	public List<Student> findFirstName(String firstName) {
		TypedQuery<Student> query = manager.createQuery("select e from Student e where e.firstName=: theFirstName ",Student.class);
		query.setParameter("theFirstName", firstName);
		return query.getResultList();
	}

	@Override
	public List<Student> findByEmail(String email) {
		TypedQuery<Student> query = manager.createQuery("select e from Student e where e.email=: theEmail ",Student.class);
		query.setParameter("theEmail", email);
		return query.getResultList();
		
	}

	

	@Override
	@Transactional //for save and update
	public void update(Student student) {
		
		Student student1 = manager.merge(student);
		System.out.println(student1);
		
		
//		TypedQuery<Student> query = manager.createQuery("update Student set id=:theId, firstName=:theFirstName,lastName=:theLastName,email=:theEmail where id =: theId",Student.class);
//		query.setParameter("theFirstName", student.getFirstName());
//	    query.setParameter("theLastName", student.getLastName());
//	    query.setParameter("theEmail", student.getEmail());
//	    query.setParameter("theId", student.getId());
//	    return query.getSingleResult();
	
	}

	@Override
	@Transactional //for save and update and delete.. use for all ddl operation
	public void detelteStudent(int id) {
		Student student = manager.find(Student.class,id);
		manager.remove(student);
		System.out.println("student remove successfully");
	}

	@Override
	@Transactional //for save and update and delete.. use for all ddl operation
	public void deleteAll() {
		int rows = manager.createQuery("delete from Student").executeUpdate();
		System.out.println(rows);
	}

}
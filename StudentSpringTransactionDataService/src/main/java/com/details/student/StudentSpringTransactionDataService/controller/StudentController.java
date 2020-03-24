package com.details.student.StudentSpringTransactionDataService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.details.student.StudentSpringTransactionDataService.model.Student;
import com.details.student.StudentSpringTransactionDataService.repository.StudentRepo;

@RestController
@RequestMapping("/student")

public class StudentController {
	
	@Autowired
	private StudentRepo repo;
	
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student.getSubjects().get(0));
		return repo.save(student);
		 
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	@GetMapping("/get")
	public List<Student> getStudents() {
		
		return repo.findAll();
		 
	}
	

}

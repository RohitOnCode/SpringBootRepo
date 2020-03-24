package com.details.student.StudentSpringTransactionSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.details.student.StudentSpringTransactionSpringBoot.model.Student;
import com.details.student.StudentSpringTransactionSpringBoot.service.StudentService;

@RestController()
@RequestMapping(value= "/api/student")
@Transactional(propagation=Propagation.REQUIRED)
public class StudentController {
	
	@Autowired
	private StudentService service;
	@GetMapping("/getStudents")
	public List<Student> getAllStudent() {
		
		return service.getStudents();
		
	
	}
	
	
	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student student) {
		
		return student;
	}

}

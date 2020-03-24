package com.details.student.StudentSpringTransactionDataService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.details.student.StudentSpringTransactionDataService.model.University;
import com.details.student.StudentSpringTransactionDataService.repository.UniversityRepo;

@RestController
@RequestMapping("/university")
public class UniversityController {
	
	@Autowired
	private UniversityRepo repo;
	
	
	@PostMapping("/create")
	public University createUniv(@RequestBody University univ) {
	
		return repo.save(univ);
		 
	}
	
	
	@GetMapping("/get")
	public List<University> getUnivs() {
		
		return repo.findAll();
		 
	}
	

}

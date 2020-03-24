package com.details.student.StudentSpringTransactionSpringBoot.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.details.student.StudentSpringTransactionSpringBoot.model.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
@Transactional(propagation=Propagation.REQUIRED)
public class StudentService {

	private RestTemplate restTemplate= new RestTemplate();
	
	
	public List<Student> getStudents() {
		String uri = "http://localhost:9197/student/get";
		return convertToMap(restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<Object>() {
		}).getBody());
		
	}
	
	
/**
 * 
 * this method is used to convert the fetched list of maps to list of Studcent entity. 
 * @param obj
 * @return
 */
public  List<Student> convertToMap(Object obj) {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		System.out.println(obj.toString());
		
			return mapper.convertValue(obj,new TypeReference<List<List<Student>>>() {}).get(0);
		
		
	}
}

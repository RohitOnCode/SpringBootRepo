package com.details.student.StudentSpringTransactionDataService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement 
public class StudentSpringTransactionDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentSpringTransactionDataServiceApplication.class, args);
	}

}

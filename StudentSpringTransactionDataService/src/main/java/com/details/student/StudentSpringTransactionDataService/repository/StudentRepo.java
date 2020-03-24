package com.details.student.StudentSpringTransactionDataService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.details.student.StudentSpringTransactionDataService.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, String> {

}

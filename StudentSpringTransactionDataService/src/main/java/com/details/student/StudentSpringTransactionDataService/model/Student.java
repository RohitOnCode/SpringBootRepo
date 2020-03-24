package com.details.student.StudentSpringTransactionDataService.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Student")
public class Student implements Serializable {

	private static final long serialVersionUID = -2517851941873251699L;

	@Column(name = "STUDENT_NAME", unique = false, nullable = false)
	String studentName;

	@Id
	@Column(unique = false, nullable = false)
	private String studentId;

	@Column(name = "STUDENT_DEPT", unique = false, nullable = false)
	private String studentDept;

	@Column(name = "STUDENT_DOJ", unique = false, nullable = false)
	private String studentDOJ;

	@Column(name = "STUDENT_ADDRESS", unique = false, nullable = false)
	private String studentAddress;

	/*
	 * This is bidirectional relationship foreign key university_id in student table
	 * references primary natural key universityId in university table We can always
	 * have universityId as the sole primary key without making it as naturalkey and
	 * without having id field as primary key in university table
	 */
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "UNIVERSITY_ID", referencedColumnName = "UNIVERSITY_ID")
	@JsonIgnoreProperties("students")
	private University university;

	/*
	 * here bidirectional relationship between student and subject ,
	 */

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_SUBJECT", joinColumns = {
			@JoinColumn(name = "STUDENT_ID", referencedColumnName = "studentId") }, inverseJoinColumns = {
					@JoinColumn(name = "SUBJECT_ID", referencedColumnName = "subjectId") })
	@JsonIgnoreProperties("students")
	private List<Subject> subjects = new ArrayList<>();

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentDept() {
		return studentDept;
	}

	public void setStudentDept(String studentDept) {
		this.studentDept = studentDept;
	}

	public String getStudentDOJ() {
		return studentDOJ;
	}

	public void setStudentDOJ(String studentDOJ) {
		this.studentDOJ = studentDOJ;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

}

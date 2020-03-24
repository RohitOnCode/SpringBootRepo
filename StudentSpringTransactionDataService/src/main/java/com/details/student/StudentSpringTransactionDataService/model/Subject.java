package com.details.student.StudentSpringTransactionDataService.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Subject"/*, uniqueConstraints = { @UniqueConstraint(columnNames = "ID") }*/)
public class Subject implements Serializable {

	private static final long serialVersionUID = -2517851941873251698L;
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name = "ID", unique = true, nullable = false) private int id;
	 * 
	 * public int getId() { return id; }
	 * 
	 * public void setId(int id) { this.id = id; }
	 */

	@Id
	String subjectId;
	@Column(name = "SUBJECT_NAME", unique = false, nullable = false)
	String subjectName;
	@Column(name = "COURSE_NAME", unique = false, nullable = false)
	String courseName;

	@ManyToMany(mappedBy = "subjects")
	@JsonIgnoreProperties("subjects")
	private List<Student> students =new ArrayList<>();

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}

package com.details.student.StudentSpringTransactionDataService.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "University", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
public class University implements Serializable {

	private static final long serialVersionUID = -2517851941873251799L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;

	
	
	@NaturalId
	@Column(name = "UNIVERSITY_ID", unique = false, nullable = false)
	String universityId;
	@Column(name = "UNIVERSITY_NAME", unique = false, nullable = false)
	String universityName;

	@Column(name = "UNIVERSITY_ADDRESS", unique = false, nullable = false)
	String universityAddress;

	@OneToMany(mappedBy = "university", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}


	

	public String getUniversityId() {
		return universityId;
	}

	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getUniversityAddress() {
		return universityAddress;
	}

	public void setUniversityAddress(String universityAddress) {
		this.universityAddress = universityAddress;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((universityAddress == null) ? 0 : universityAddress.hashCode());
		result = prime * result + ((universityId == null) ? 0 : universityId.hashCode());
		result = prime * result + ((universityName == null) ? 0 : universityName.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		University other = (University) obj;
		if (universityAddress == null) {
			if (other.universityAddress != null)
				return false;
		} else if (!universityAddress.equals(other.universityAddress))
			return false;
		if (universityId == null) {
			if (other.universityId != null)
				return false;
		} else if (!universityId.equals(other.universityId))
			return false;
		if (universityName == null) {
			if (other.universityName != null)
				return false;
		} else if (!universityName.equals(other.universityName))
			return false;
		return true;
	}

}

package br.com.salao.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	 
	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;
	
	@ManyToMany  
	@JoinTable(
		name = "student_course",
		joinColumns = @JoinColumn(name = "student_id"),
		inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	private List<Course> courses = new ArrayList<>();
	
	public Student(String name) {
		this(null, name, null);
	}
	
	public Student(String name, Passport passport) {
		this(null, name, passport);
	}
	
	public Student(Long id, String name, Passport passport) {
		this.id = id;
		this.name = name;
		this.passport = passport;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
}

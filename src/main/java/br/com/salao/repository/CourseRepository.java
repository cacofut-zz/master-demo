package br.com.salao.repository;

import br.com.salao.entity.Course;

public interface CourseRepository {
	
	public Course findById(Long id);
	
}

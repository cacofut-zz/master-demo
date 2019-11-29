package br.com.salao.repository;

import br.com.salao.entity.Course;

public interface CourseRepository {
	
	public Course findById(Long id);
	
	public void deleteById(Long id);
	
	public void save(Course course);
	
	public void update(Course course);
}

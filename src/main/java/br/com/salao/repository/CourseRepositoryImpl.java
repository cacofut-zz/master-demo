package br.com.salao.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.salao.entity.Course;

@Repository
public class CourseRepositoryImpl implements CourseRepository{

	@PersistenceContext
	private EntityManager emt;
	
	@Override
	public Course findById(Long id) {		
		return emt.find(Course.class, id);
	}

	
}

package br.com.salao.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.salao.entity.Course;

@Repository
@Transactional
public class CourseRepositoryImpl implements CourseRepository{

	@PersistenceContext
	private EntityManager emt;
	
	@Override
	public Course findById(Long id) {		
		return emt.find(Course.class, id);
	}

	@Override
	public void deleteById(Long id) {
		Course course = findById(id);	
		emt.remove(course);
	}

	@Override
	public void save(Course course) {
		emt.persist(course);		
	}

	@Override
	public void update(Course course) {
		emt.merge(course);		
	}

	
}

package br.com.salao.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.salao.entity.Passport;
import br.com.salao.entity.Student;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository{

	@PersistenceContext
	private EntityManager emt;
		
	@Override
	public Student findById(Long id) {		
		return emt.find(Student.class, id);
	}

	@Override
	public void deleteById(Long id) {
		Student student = findById(id);
		emt.remove(student);		
	}

	@Override
	public void save(Student student) {
		emt.persist(student);		
	}

	@Override
	public void update(Student student) {
		emt.persist(student);
	}
	
	
	public void playWithEntityManager() {
		Passport passport = new Passport("EA121212");
		emt.persist(passport);
		
		Student student = new Student("Novo student", passport);
		emt.persist(student);
	}

}

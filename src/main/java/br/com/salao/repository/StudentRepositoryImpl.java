package br.com.salao.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.salao.entity.Course;
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
	
	public void insertStudentWithCourse() {
		Passport passport1 = new Passport("GHJFJ123");
		emt.persist(passport1);
		
		Student student1 = new Student("Rafael Julio Carneiro");
		Course course1   = new Course("Estratégias de Marketing"); 
		
		emt.persist(student1);
		emt.persist(course1);
		
		passport1.setStudent(student1);
		student1.setPassport(passport1);
					
		emt.persist(student1);
	}

}

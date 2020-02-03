package br.com.salao.repository;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import br.com.salao.MasterDemoApplication;
import br.com.salao.entity.Passport;
import br.com.salao.entity.Student;

@SpringBootTest(classes = MasterDemoApplication.class)
public class StudentRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EntityManager em;
	
	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}", student.getPassport());
	}
	
	@Test
	@Transactional
	public void retrievePassportAndAssociateStudent() {
		Passport passport = em.find(Passport.class, 30001L);
		logger.info("passport -> {}", passport);
		logger.info("student -> {}", passport.getStudent());
	}
	
	
	@Test
	@Transactional
	public void retrieveStudentAndCourses() {		
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}", student);		
		logger.info("courses -> {}", student.getCourses());
	}

	
}

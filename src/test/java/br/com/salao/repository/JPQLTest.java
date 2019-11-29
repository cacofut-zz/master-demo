package br.com.salao.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.salao.MasterDemoApplication;
import br.com.salao.entity.Course;

@SpringBootTest(classes = MasterDemoApplication.class)
class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EntityManager em;
	
	@Test
	public void jpql_find_all() {
		
		TypedQuery<Course> typedQuery = em.createQuery("SELECT c FROM Course c", Course.class);
		List<Course> courses = typedQuery.getResultList();
		
		logger.info("SELECT c FROM Course c -> {}", courses);
	}
	
	@Test
	public void jpql_where() {
		TypedQuery<Course> typedQuery = em.createQuery("SELECT c FROM Course c WHERE name LIKE '%Ciências%'", Course.class);						
		List<Course> courses = typedQuery.getResultList();
		logger.info("SELECT c FROM Course c WHERE name LIKE '%Ciências%' -> {}", courses);
	}

}

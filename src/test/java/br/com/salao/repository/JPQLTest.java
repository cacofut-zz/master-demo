package br.com.salao.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Test
	public void jpql_named_query() {
		TypedQuery<Course> typedNamedQuery = em.createNamedQuery("select_all_courses", Course.class);
		List<Course> courses = typedNamedQuery.getResultList();
		logger.info("NamedQuery select_all_courses -> {}", courses);
				
	}

	@Test
	public void jpql_named_query_condition() {
		TypedQuery<Course> typedNamedQuery = em.createNamedQuery("select_all_courses_condition", Course.class);
		List<Course> courses = typedNamedQuery.getResultList();
		logger.info("NamedQuery Condition -> {}", courses);
	}
	
	@Test
	public void native_queries_basic() {
		Query nativeQuery = em.createNativeQuery("SELECT * FROM COURSE", Course.class);
		List<Course> courses = nativeQuery.getResultList();
		logger.info("Native Queries -> {}", courses);
	}
	
	@Test
	public void native_queries_with_parameter() {
		Query nativeQuery = em.createNativeQuery("SELECT * FROM COURSE WHERE id = ?", Course.class);
		nativeQuery.setParameter(1, 10001L);
		List<Course> courses = nativeQuery.getResultList();
		logger.info("Native Query With parameter -> {}", courses);
	}
	
	@Test
	public void native_queries_with_named_parameter() {
		Query nativeQuery = em.createNativeQuery("SELECT * FROM COURSE WHERE id = :id", Course.class);
		nativeQuery.setParameter("id", 10001L);
		List<Course> courses = nativeQuery.getResultList();
		logger.info("Natives Queries With named parameter -> {}", courses);
	}
	
	@Test
	@Transactional
	public void native_queries_to_update() {
		Query nativeQuery = em.createNativeQuery("UPDATE COURSE SET last_updated_date = sysdate()");
		int noOfRowsUpdated = nativeQuery.executeUpdate();
		logger.info("noOfRowsUpdated -> {}", noOfRowsUpdated);
	}
}

package br.com.salao.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import br.com.salao.MasterDemoApplication;
import br.com.salao.entity.Course;

@SpringBootTest(classes = MasterDemoApplication.class)
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void findById_basic() {
		Course course = courseRepository.findById(10001L);
		assertEquals("Ciências da Computação", course.getName());
	}
	
	@Test
	@DirtiesContext
	public void deleteById_basic() {
		courseRepository.deleteById(10001L);
		assertNull(courseRepository.findById(10001L));
	}
	
	@Test
	@DirtiesContext
	public void save_basic() {
		Course course = courseRepository.findById(10002L);
		String oldName = "Análise e Desenvolvimento de Sistemas";
		String newName = oldName + " update";
		assertEquals(oldName, course.getName());
							
		course.setName(newName);
		courseRepository.update(course);
		
		course = courseRepository.findById(10002L);
		assertEquals(newName, course.getName());
		
		
		
	}
	
}

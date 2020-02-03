package br.com.salao.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.salao.entity.Course;
import br.com.salao.entity.Review;

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
		
	public void playWithEntityManager() {
		Course course1 = new Course("Teste de Implantação");
		emt.persist(course1);
		
		Course course2 = new Course("Desenho Artistico");
		emt.persist(course2);
		
		emt.flush(); // realiza as alterações imediatamente
		
		//emt.clear(); // destaca o objeto do entitymanager e não é mais gerenciado por ele
				
		//course1.setName("Teste de Implantação - update");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		course2.setName("Desenho Artistico - update");
		
		//emt.refresh(course1);
		
		emt.flush();
		
	}

	/**
	 * 
	 */
	public void addReviews() {
		Course course = findById(10003L);
			
		Review r1 = new Review("The is OK", "3");
		Review r2 = new Review("The is awful", "1");
		
		r1.setCourse(course);
		r2.setCourse(course);
		
		course.addReview(r1);
		course.addReview(r2);
		
		emt.persist(r1);
		emt.persist(r2);
		
		
	}
	
	/**
	 * 
	 * @param courseId
	 * @param reviews
	 */
	public void addReviewToCourse(Long courseId, List<Review> reviews) {
		Course course = findById(courseId);
		for (Review review : reviews) {
			course.addReview(review);
			review.setCourse(course);
			emt.persist(review);
		}
	}
	
}

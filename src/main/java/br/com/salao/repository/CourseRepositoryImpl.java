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
		
	public void playWithEntityManager() {
		Course course1 = new Course("Teste de Implantação");
		emt.persist(course1);
		
		Course course2 = new Course("Desenho Artistico");
		emt.persist(course2);
		
		emt.flush(); // realiza as alterações imediatamente
		
		//emt.clear(); // destaca o objeto do entitymanager e não e não é mais gerenciado por ele
				
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

	
}

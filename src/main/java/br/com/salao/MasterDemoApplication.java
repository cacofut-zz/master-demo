package br.com.salao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.salao.entity.HourlyEmployee;
import br.com.salao.entity.SalariedEmployee;
import br.com.salao.repository.CourseRepositoryImpl;
import br.com.salao.repository.EmployeRepository;
import br.com.salao.repository.StudentRepositoryImpl;

@SpringBootApplication
public class MasterDemoApplication implements CommandLineRunner{

	@Autowired 
	private CourseRepositoryImpl courseRepository;
	
	@Autowired
	private StudentRepositoryImpl studentRepository;
	
	@Autowired
	private EmployeRepository employeeRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public static void main(String[] args) {
		SpringApplication.run(MasterDemoApplication.class, args);
	}
	
	public void run( String... args ) {
		//logger.info( "Course -> {}", courseRepository.findById(10001L) );		
		//courseRepository.save(new Course("Curso de Integração de Posses"));
		//courseRepository.playWithEntityManager();
		
		
		
		//List<Review> reviews = new ArrayList<>();
		//r/eviews.add(new Review("The is OK", "3"));
		//reviews.add(new Review("The is awful", "1"));
		
		studentRepository.playWithEntityManager();
		//courseRepository.addReviews();
		//studentRepository.insertStudentWithCourse();
		//courseRepository.addReviewToCourse(10003L, reviews );
		
		SalariedEmployee e1 = new SalariedEmployee(null, "Cristiano", "01");		
		HourlyEmployee e2 = new HourlyEmployee(null, "João", "chave");
		
		//Review r = new Review("dsds", "");
		//em.persist(r);
		
		employeeRepository.insert(e1);
		employeeRepository.insert(e2);
		
		
		logger.info("All employees -> {}", employeeRepository.retriveAllEmployees());
				 
	}



}

	

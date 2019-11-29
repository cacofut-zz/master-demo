package br.com.salao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.salao.entity.Course;
import br.com.salao.repository.CourseRepository;

@SpringBootApplication
public class MasterDemoApplication implements CommandLineRunner{

	@Autowired 
	private CourseRepository courseRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(MasterDemoApplication.class, args);
	}
	
	public void run( String... args ) {
		//logger.info( "Course -> {}", courseRepository.findById(10001L) );
		
		//courseRepository.save(new Course("Curso de Integração de Posses"));
				 
	}



}

	

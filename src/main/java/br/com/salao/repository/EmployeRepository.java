package br.com.salao.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.salao.entity.Employee;

@Repository
@Transactional
public class EmployeRepository {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Employee e) {
		em.persist(e);			
	}
	
	public List<Employee> retriveAllEmployees() {
		List<Employee> employees = em.createQuery("SELECT e from Employee e", Employee.class).getResultList();
		return employees;
	}
}

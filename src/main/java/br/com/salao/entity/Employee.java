package br.com.salao.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;


@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // unique table
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)
//@MappedSuperclass
//@DiscriminatorColumn(name = "EmployeeType") with table single_table
public abstract class Employee { 

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;	

	public Employee() {		
	}
		
	public Employee(Long id, String name) {	
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	
}

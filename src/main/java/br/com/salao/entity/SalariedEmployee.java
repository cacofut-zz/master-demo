package br.com.salao.entity;

import javax.persistence.Entity;

@Entity
public class SalariedEmployee extends Employee{

	private String tipo;

	public SalariedEmployee() {		
	}
		
	public SalariedEmployee(Long id, String name, String tipo) {
		super(id, name);
		this.tipo =  tipo;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
	
	
	
}

package br.com.salao.entity;

import javax.persistence.Entity;

import lombok.Data;


@Entity
public class HourlyEmployee extends Employee{

	private String key;
		
	public HourlyEmployee() {
			
	}

	public HourlyEmployee(Long id, String name, String key) {
		super(id, name);
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
}

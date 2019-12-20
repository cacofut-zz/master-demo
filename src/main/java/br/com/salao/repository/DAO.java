package br.com.salao.repository;

public interface DAO<T, R> {

	public T findById(R id);
	
	public void deleteById(R id);
	
	public void save(T object);
	
	public void update(T object);
}

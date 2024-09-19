package edu.dgtic.isp.service;

import java.util.List;

import edu.dgtic.isp.entity.Entity;

//common interface to be implemented by all persistence services. 
public interface PersistenceService<T extends Entity> {
	void save(T entity);
	void delete(T entity);
	T findById(Long id);
	List<T> findByName(String name);
}

package edu.dgtic.isp.service;

import edu.dgtic.isp.entity.Entity;

//common interface to be implemented by all persistence services. 
public interface EntityPersistenceService<T extends Entity> {
	void save(T entity);
	void delete(T entity);
	T findById(Long id);
}
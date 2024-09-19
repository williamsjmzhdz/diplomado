package edu.unam.agenda.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
    Boolean save(T entity);
    T get(ID id);
    Boolean delete(T entity);
    List<T> findAll();
}
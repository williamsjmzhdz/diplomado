package edu.unam.proyecto_final.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <E, ID extends Serializable> {
    Boolean create(E entity);
    Boolean update(E entity);
    E get(ID id);
    Boolean delete(E entity);
    List<E> findAll();
}

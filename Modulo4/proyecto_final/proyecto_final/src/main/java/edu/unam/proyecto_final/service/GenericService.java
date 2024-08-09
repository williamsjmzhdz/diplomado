package edu.unam.proyecto_final.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<E, ID extends Serializable> {
    Boolean create(E entity);
    Boolean update(E entity);
    E get(ID id);
    Boolean delete(E entity);
    List<E> findAll();
}

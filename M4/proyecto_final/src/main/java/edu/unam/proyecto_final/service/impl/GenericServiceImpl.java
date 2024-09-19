package edu.unam.proyecto_final.service.impl;

import edu.unam.proyecto_final.dao.GenericDAO;
import edu.unam.proyecto_final.service.GenericService;

import java.io.Serializable;
import java.util.List;

public class GenericServiceImpl<D extends GenericDAO<E, ID>, E, ID extends Serializable> implements GenericService<E, ID> {

    protected final D dao;

    GenericServiceImpl(D dao) {
        this.dao = dao;
    }

    @Override
    public Boolean create(E entity) {
        return dao.create(entity);
    }

    @Override
    public Boolean update(E entity) {
        return dao.update(entity);
    }

    @Override
    public E get(ID id) {
        return dao.get(id);
    }

    @Override
    public Boolean delete(E entity) {
        return dao.delete(entity);
    }

    @Override
    public List<E> findAll() {
        return dao.findAll();
    }
}


package edu.dgtic.isp.service;

import edu.dgtic.isp.entity.Entity;

import java.util.List;

public interface NamedEntityPersistenceService<T extends Entity> {
    List<T> findByName(String name);
}

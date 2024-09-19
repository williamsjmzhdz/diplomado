package edu.unam.proyecto_final.dao.impl;

import edu.unam.proyecto_final.dao.GenericDAO;
import edu.unam.proyecto_final.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericDAOImpl<E, ID extends Serializable> implements GenericDAO<E, ID> {

    @Override
    public Boolean create(E entity) {
        Boolean saved = Boolean.FALSE;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            session.persist(entity); // Utiliza persist para enfatizar que es para nuevas entidades
            session.getTransaction().commit();
            saved = Boolean.TRUE;
        } catch (Exception ex) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            System.out.println("Exception while creating entity: " + ex);
        } finally {
            session.close();
        }

        return saved;
    }

    @Override
    public Boolean update(E entity) {
        Boolean updated = Boolean.FALSE;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            session.merge(entity); // Utiliza merge para manejar la actualización
            session.getTransaction().commit();
            updated = Boolean.TRUE;
        } catch (Exception ex) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            System.out.println("Exception while updating entity: " + ex);
        } finally {
            session.close();
        }

        return updated;
    }


    @Override
    public E get(ID id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        E entity = null;

        try {
            session.beginTransaction();
            entity = (E) session.get(findEntityClass(), id);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            System.out.println("Fallo al hacer un rollback=" + ex);
            throw new RuntimeException(ex);
        } finally {
            session.close();
        }

        return entity;
    }


    @Override
    public Boolean delete(E entity) {
        Boolean deleted = Boolean.FALSE;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            if (entity != null) {
                session.delete(entity);
                session.getTransaction().commit();
                deleted = Boolean.TRUE;
            }
        } catch (Exception ex) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            System.out.println("Fallo al hacer un rollback=" + ex);
            throw new RuntimeException(ex);
        } finally {
            session.close();
        }

        return deleted;
    }


    @Override
    @SuppressWarnings({"unchecked", "unchecked"})
    public List<E> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<E> entities = null;

        try {
            session.beginTransaction();
            entities = session.createQuery("FROM " + findEntityClass().getName()).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            System.out.println("Fallo al realizar la consulta: " + e);
            throw new RuntimeException(e);
        } finally {
            session.close();
        }

        return entities;
    }


    @SuppressWarnings("unchecked")
    public final Class<E> findEntityClass() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        for (Type type : genericSuperClass.getActualTypeArguments()) {
            if (type instanceof ParameterizedType) {
                return (Class<E>)((ParameterizedType) type).getRawType();
            } else if (type instanceof Class<?>) {
                return (Class<E>)type;
            }
        }
        return null;
    }
}

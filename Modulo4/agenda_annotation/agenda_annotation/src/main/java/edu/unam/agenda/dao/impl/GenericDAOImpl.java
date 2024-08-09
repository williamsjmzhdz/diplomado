package edu.unam.agenda.dao.impl;

import edu.unam.agenda.dao.GenericDAO;
import edu.unam.agenda.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

    //private Class<T> persistenClass;
    SessionFactory sessionFactory;

    public GenericDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
        //this.persistenClass = findEntityClass();
    }

    @Override
    public Boolean save(T entity) {
        Boolean saved = Boolean.FALSE;  // Initially, assume saving will fail.
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
            saved = Boolean.TRUE;  // Set to TRUE as the entity has been saved without exceptions.
        } catch (Exception ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();  // Attempt to rollback if there was an issue.
                }
            } catch (Exception exc) {
                System.out.println("Failed to rollback: " + exc);
            }
            saved = Boolean.FALSE;  // Explicitly set to FALSE to clarify that saving failed.
            System.out.println("Exception while saving entity: " + ex);
        }

        return saved;
    }


    @Override
    public T get(ID id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            T entity = (T) session.get(findEntityClass(), id);
            session.getTransaction().commit();

            return entity;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                System.out.println("Fallo al hacer un rollback=" + exc);
            }
            throw ex;
        }
    }

    @Override
    public Boolean delete(T entity) {
        Boolean saved = Boolean.FALSE;
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            if (entity != null) {
                session.delete(entity);
                session.getTransaction().commit();
            }
            saved = Boolean.TRUE;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                System.out.println("Fallo al hacer un rollback=" + exc);
            }
            throw ex;
        }

        return saved;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        List<T> entities = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            entities = session.createQuery("SELECT e FROM " + findEntityClass().getName() + " e").getResultList();
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return entities;
    }

    @SuppressWarnings("unchecked")
    public final Class<T> findEntityClass() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        for (Type type : genericSuperClass.getActualTypeArguments()) {
            if (type instanceof ParameterizedType) {
                return (Class<T>)((ParameterizedType) type).getRawType();
            } else if (type instanceof Class<?>) {
                return (Class<T>)type;
            }
        }
        return null;
    }
}

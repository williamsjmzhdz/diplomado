package edu.unam.proyecto_final.dao.impl;

import edu.unam.proyecto_final.dao.UsuarioRolDAO;
import edu.unam.proyecto_final.hibernate.HibernateUtil;
import edu.unam.proyecto_final.model.Rol;
import edu.unam.proyecto_final.model.Usuario;
import edu.unam.proyecto_final.model.UsuarioRol;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UsuarioRolDAOImpl extends GenericDAOImpl<UsuarioRol, Integer> implements UsuarioRolDAO {
    private static UsuarioRolDAOImpl instance;

    private UsuarioRolDAOImpl() {
        super();
    }

    public static UsuarioRolDAOImpl getInstance() {
        if (instance == null)
            instance = new UsuarioRolDAOImpl();
        return instance;
    }

    public UsuarioRol findByUsuarioAndRol(Usuario usuario, Rol rol) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        UsuarioRol usuarioRol = null;

        try {
            session.beginTransaction();
            String hql = "FROM UsuarioRol ur WHERE ur.usuario = :usuario AND ur.rol = :rol";
            Query<UsuarioRol> query = session.createQuery(hql, UsuarioRol.class);
            query.setParameter("usuario", usuario);
            query.setParameter("rol", rol);
            usuarioRol = query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw e;
        }

        return usuarioRol;
    }
}

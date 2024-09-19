package edu.unam.proyecto_final.dao.impl;

import edu.unam.proyecto_final.dao.UsuarioDAO;
import edu.unam.proyecto_final.model.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO {

    private static UsuarioDAOImpl instance;

    private UsuarioDAOImpl() {
        super();
    }

    public static UsuarioDAOImpl getInstance() {
        if (instance == null)
            instance = new UsuarioDAOImpl();
        return instance;
    }

}

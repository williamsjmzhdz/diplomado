package edu.unam.proyecto_final.dao.impl;

import edu.unam.proyecto_final.dao.RolDAO;
import edu.unam.proyecto_final.model.Rol;

public class RolDAOImpl extends GenericDAOImpl<Rol, Integer> implements RolDAO {

    private static RolDAOImpl instance;

    private RolDAOImpl() {}

    public static RolDAOImpl getInstance() {
        if (instance == null) {
            instance = new RolDAOImpl();
        }
        return instance;
    }

}

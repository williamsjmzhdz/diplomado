package edu.unam.proyecto_final.service.impl;

import edu.unam.proyecto_final.dao.RolDAO;
import edu.unam.proyecto_final.dao.impl.RolDAOImpl;
import edu.unam.proyecto_final.model.Rol;
import edu.unam.proyecto_final.service.RolService;

public class RolServiceImpl extends GenericServiceImpl<RolDAO, Rol, Integer> implements RolService {

    private static RolServiceImpl instance;

    private RolServiceImpl(RolDAO rolDAO) {
        super(rolDAO);
    }

    public static RolServiceImpl getInstance() {
        if (instance == null) {
            instance = new RolServiceImpl(RolDAOImpl.getInstance());
        }
        return instance;
    }

}

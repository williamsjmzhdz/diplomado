package edu.unam.proyecto_final.service.impl;

import edu.unam.proyecto_final.dao.UsuarioDAO;
import edu.unam.proyecto_final.model.Usuario;
import edu.unam.proyecto_final.service.UsuarioService;
import edu.unam.proyecto_final.dao.impl.UsuarioDAOImpl;

public class UsuarioServiceImpl extends GenericServiceImpl<UsuarioDAO, Usuario, Integer> implements UsuarioService {

    private static UsuarioServiceImpl instance;

    private UsuarioServiceImpl(UsuarioDAO usuarioDAO) {
        super(usuarioDAO);
    }

    public static UsuarioServiceImpl getInstance() {
        if (instance == null) {
            instance = new UsuarioServiceImpl(UsuarioDAOImpl.getInstance()); // Usa directamente la instancia de UsuarioDAOImpl
        }
        return instance;
    }

}

package edu.unam.proyecto_final.service.impl;

import edu.unam.proyecto_final.dao.UsuarioRolDAO;
import edu.unam.proyecto_final.dao.impl.UsuarioRolDAOImpl;
import edu.unam.proyecto_final.model.Rol;
import edu.unam.proyecto_final.model.Usuario;
import edu.unam.proyecto_final.model.UsuarioRol;
import edu.unam.proyecto_final.service.RolService;
import edu.unam.proyecto_final.service.UsuarioRolService;
import edu.unam.proyecto_final.service.UsuarioService;

import java.time.LocalDateTime;

public class UsuarioRolServiceImpl extends GenericServiceImpl<UsuarioRolDAO, UsuarioRol, Integer> implements UsuarioRolService {

    private static UsuarioRolServiceImpl instance;
    private static UsuarioService usuarioService;
    private static RolService rolService;

    private UsuarioRolServiceImpl(UsuarioRolDAO usuarioRolDAO) {
        super(usuarioRolDAO);
    }

    public static UsuarioRolServiceImpl getInstance() {
        if (instance == null) {
            instance = new UsuarioRolServiceImpl(UsuarioRolDAOImpl.getInstance());
        }
        instance.setUsuarioService(UsuarioServiceImpl.getInstance());
        instance.setRolService(RolServiceImpl.getInstance());
        return instance;
    }

    private void setUsuarioService(UsuarioServiceImpl instance) {
        usuarioService = instance;
    }

    private void setRolService(RolServiceImpl instance) {
        rolService = instance;
    }

    @Override
    public Boolean assignRoleToUser(int usuarioId, int rolId) {
        Usuario usuario = usuarioService.get(usuarioId);
        Rol rol = rolService.get(rolId);

        if (usuario != null && rol != null) {
            // Verificar primero si ya existe una relación UsuarioRol con los mismos Usuario y Rol
            UsuarioRol existingUsuarioRol = dao.findByUsuarioAndRol(usuario, rol);

            if (existingUsuarioRol != null) {
                // Si ya existe, no hacer nada y retornar false indicando que no se realizó ninguna operación nueva
                return false;
            }

            // Si no existe, crear una nueva asignación de rol
            UsuarioRol usuarioRol = new UsuarioRol();
            usuarioRol.setUsuario(usuario);
            usuarioRol.setRol(rol);
            usuarioRol.setFechaAsignacion(LocalDateTime.now());
            return dao.create(usuarioRol);  // Esto debería retornar true si la creación fue exitosa
        }

        // Si el usuario o el rol no existen, retornar false
        return false;
    }


    @Override
    public Boolean removeRoleToUser(int usuarioId, int rolId) {
        Usuario usuario = usuarioService.get(usuarioId);
        Rol rol = rolService.get(rolId);

        if (usuario != null && rol != null) {
            UsuarioRol usuarioRol = dao.findByUsuarioAndRol(usuario, rol);
            if (usuarioRol != null) {
                return dao.delete(usuarioRol);
            }
        }
        return false;
    }
}

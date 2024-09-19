package edu.unam.proyecto_final.service;

import edu.unam.proyecto_final.model.UsuarioRol;

public interface UsuarioRolService extends GenericService<UsuarioRol, Integer> {
    Boolean assignRoleToUser(int usuarioId, int rolId);
    Boolean removeRoleToUser(int usuarioId, int rolId);
}

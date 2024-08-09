package edu.unam.proyecto_final.dao;

import edu.unam.proyecto_final.model.Rol;
import edu.unam.proyecto_final.model.Usuario;
import edu.unam.proyecto_final.model.UsuarioRol;

public interface UsuarioRolDAO extends GenericDAO<UsuarioRol, Integer> {
    UsuarioRol findByUsuarioAndRol(Usuario usuario, Rol rol);
}

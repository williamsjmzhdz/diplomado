package dgtic.core.service;

import dgtic.core.model.Usuario;

import java.util.List;

public interface UsuarioService {

    void guardar(Usuario usuario);
    Usuario encontrarPorId(Integer id);
    void actualizar(Usuario usuario);
    void eliminar(Integer id);
    List<Usuario> encontrarTodos();

}

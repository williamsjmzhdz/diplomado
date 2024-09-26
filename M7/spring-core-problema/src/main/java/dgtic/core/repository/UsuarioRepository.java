package dgtic.core.repository;

import dgtic.core.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {

    void guardar(Usuario usuario);
    Optional<Usuario> encontrarPorId(Integer id);
    void actualizar(Usuario usuario);
    void eliminar(Integer id);
    List<Usuario> encontrarTodos();
    Optional<Usuario> encontrarPorCorreoElectronico(String correoElectronico);

}

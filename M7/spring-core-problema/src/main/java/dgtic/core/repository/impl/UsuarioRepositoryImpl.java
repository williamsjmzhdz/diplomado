package dgtic.core.repository.impl;

import dgtic.core.model.Usuario;
import dgtic.core.repository.BaseDeDatos;
import dgtic.core.repository.UsuarioRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private BaseDeDatos baseDeDatos = new BaseDeDatosImpl();

    @Override
    public void guardar(Usuario usuario) {
        baseDeDatos.guardarUsuario(usuario);
    }

    @Override
    public Optional<Usuario> encontrarPorId(Integer id) {
        return baseDeDatos.buscarUsuarioPorId(id);
    }

    @Override
    public void actualizar(Usuario usuario) {
        baseDeDatos.actualizarUsuario(usuario);
    }

    @Override
    public void eliminar(Integer id) {
        baseDeDatos.eliminarUsuario(id);
    }

    @Override
    public List<Usuario> encontrarTodos() {
        return baseDeDatos.getUsuarios();
    }

    @Override
    public Optional<Usuario> encontrarPorCorreoElectronico(String correoElectronico) {
        return baseDeDatos.encontrarUsuarioPorCorreoElectronico(correoElectronico);
    }
}

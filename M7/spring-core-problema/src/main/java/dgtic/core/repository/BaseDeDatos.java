package dgtic.core.repository;

import dgtic.core.model.MetodoPago;
import dgtic.core.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface BaseDeDatos {

    public void guardarUsuario(Usuario usuario);

    public Optional<Usuario> buscarUsuarioPorId(Integer id);

    public void actualizarUsuario(Usuario usuario);

    public void eliminarUsuario(Integer id);

    public void guardarMetodoPago(MetodoPago metodoPago);

    public Optional<MetodoPago> buscarMetodoPagoPorId(Integer id);

    public void actualizarMetodoPago(MetodoPago metodoPago);

    public void eliminarMetodoPago(Integer id);

    List<MetodoPago> getMetodosPago();

    List<Usuario> getUsuarios();

    Optional<Usuario> encontrarUsuarioPorCorreoElectronico(String correoElectronico);

    Optional<MetodoPago> encontrarMetodoPagoPorNumeroTarjeta(String numeroTarjeta);
}

package dgtic.core.repository.impl;

import dgtic.core.model.MetodoPago;
import dgtic.core.model.TipoTarjeta;
import dgtic.core.model.Usuario;
import dgtic.core.repository.BaseDeDatos;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BaseDeDatosImpl implements BaseDeDatos {

    public static List<Usuario> usuarios = new ArrayList<>();
    public static List<MetodoPago> metodosPago = new ArrayList<>();

    static {
        // Creación de los usuarios
        Usuario usuario1 = new Usuario(1, "Juan", "Pérez", "López", "juan.perez@example.com", "password123");
        Usuario usuario2 = new Usuario(2, "María", "Gómez", "Martínez", "maria.gomez@example.com", "password123");
        Usuario usuario3 = new Usuario(3, "Pedro", "Sánchez", "Hernández", "pedro.sanchez@example.com", "password123");

        // Agregar usuarios a la lista
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        // Creación de los métodos de pago asociados a los usuarios
        MetodoPago metodoPago1 = new MetodoPago(
                1,
                "Juan Pérez",
                "4111111111111111",
                LocalDateTime.of(2025, 12, 31, 0, 0),
                "123",
                TipoTarjeta.CREDITO,
                new BigDecimal("1000.00"),
                usuario1
        );

        MetodoPago metodoPago2 = new MetodoPago(
                2,
                "María Gómez",
                "4222222222222222",
                LocalDateTime.of(2026, 11, 30, 0, 0),
                "456",
                TipoTarjeta.DEBITO,
                new BigDecimal("500.00"),
                usuario2
        );

        MetodoPago metodoPago3 = new MetodoPago(
                3,
                "Pedro Sánchez",
                "4333333333333333",
                LocalDateTime.of(2024, 10, 31, 0, 0),
                "789",
                TipoTarjeta.CREDITO,
                new BigDecimal("750.00"),
                usuario3
        );

        // Agregar métodos de pago a la lista
        metodosPago.add(metodoPago1);
        metodosPago.add(metodoPago2);
        metodosPago.add(metodoPago3);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorId(Integer id) {
        return usuarios.stream().filter(usuario -> usuario.getId().equals(id)).findFirst();
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        buscarUsuarioPorId(usuario.getId()).ifPresent(usuarioExistente -> {
            int index = usuarios.indexOf(usuarioExistente);
            usuarios.set(index, usuario);
        });
    }

    @Override
    public void eliminarUsuario(Integer id) {
        usuarios.removeIf(usuario -> usuario.getId().equals(id));
    }

    @Override
    public void guardarMetodoPago(MetodoPago metodoPago) {
        metodosPago.add(metodoPago);
    }

    @Override
    public Optional<MetodoPago> buscarMetodoPagoPorId(Integer id) {
        return metodosPago.stream().filter(metodoPago -> metodoPago.getId().equals(id)).findFirst();
    }

    @Override
    public void actualizarMetodoPago(MetodoPago metodoPago) {
        buscarMetodoPagoPorId(metodoPago.getId()).ifPresent(metodoPagoExistente -> {
            int index = metodosPago.indexOf(metodoPagoExistente);
            metodosPago.set(index, metodoPago);
        });
    }

    @Override
    public void eliminarMetodoPago(Integer id) {
        metodosPago.removeIf(metodoPago -> metodoPago.getId().equals(id));
    }

    @Override
    public List<MetodoPago> getMetodosPago() {
        return metodosPago;
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @Override
    public Optional<Usuario> encontrarUsuarioPorCorreoElectronico(String correoElectronico) {
        return usuarios.stream().filter(usuario -> usuario.getCorreoElectronico().equals(correoElectronico)).findFirst();
    }

    @Override
    public Optional<MetodoPago> encontrarMetodoPagoPorNumeroTarjeta(String numeroTarjeta) {
        return metodosPago.stream().filter(metodoPago -> metodoPago.getNumeroTarjeta().equals(numeroTarjeta)).findFirst();
    }

}

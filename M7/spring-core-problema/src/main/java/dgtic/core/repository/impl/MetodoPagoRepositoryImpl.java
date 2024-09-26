package dgtic.core.repository.impl;

import dgtic.core.model.MetodoPago;
import dgtic.core.repository.BaseDeDatos;
import dgtic.core.repository.MetodoPagoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MetodoPagoRepositoryImpl implements MetodoPagoRepository {


    private BaseDeDatos baseDeDatos = new BaseDeDatosImpl();

    @Override
    public void guardar(MetodoPago metodoPago) {
        baseDeDatos.guardarMetodoPago(metodoPago);
    }

    @Override
    public Optional<MetodoPago> encontrarPorId(Integer id) {
        return baseDeDatos.buscarMetodoPagoPorId(id);
    }

    @Override
    public void actualizar(MetodoPago metodoPago) {
        baseDeDatos.actualizarMetodoPago(metodoPago);
    }

    @Override
    public void eliminar(Integer id) {
        baseDeDatos.eliminarMetodoPago(id);
    }

    @Override
    public List<MetodoPago> encontrarTodos() {
        return baseDeDatos.getMetodosPago();
    }

    @Override
    public Optional<MetodoPago> encontrarPorNumeroTarjeta(String numeroTarjeta) {
        return baseDeDatos.encontrarMetodoPagoPorNumeroTarjeta(numeroTarjeta);
    }
}

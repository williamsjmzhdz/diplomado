package dgtic.core.repository;

import dgtic.core.model.MetodoPago;
import java.util.List;
import java.util.Optional;

public interface MetodoPagoRepository {

    void guardar(MetodoPago metodoPago);
    Optional<MetodoPago> encontrarPorId(Integer id);
    void actualizar(MetodoPago metodoPago);
    void eliminar(Integer id);
    List<MetodoPago> encontrarTodos();
    Optional<MetodoPago> encontrarPorNumeroTarjeta(String numeroTarjeta);

}

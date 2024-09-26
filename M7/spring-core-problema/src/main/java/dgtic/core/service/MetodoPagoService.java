package dgtic.core.service;

import dgtic.core.model.MetodoPago;

import java.util.List;

public interface MetodoPagoService {

    void guardar(MetodoPago metodoPago);
    MetodoPago encontrarPorId(Integer id);
    void actualizar(MetodoPago metodoPago);
    void eliminar(Integer id);
    List<MetodoPago> encontrarTodos();

}

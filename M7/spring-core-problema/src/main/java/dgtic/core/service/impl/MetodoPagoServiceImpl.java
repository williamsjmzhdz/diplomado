package dgtic.core.service.impl;

import dgtic.core.model.MetodoPago;
import dgtic.core.model.exception.*;
import dgtic.core.repository.MetodoPagoRepository;
import dgtic.core.service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Override
    public void guardar(MetodoPago metodoPago) {
        String numeroTarjeta = metodoPago.getNumeroTarjeta();
        if (numeroTarjeta.length() != 16) throw new InvalidCardNumberException(numeroTarjeta);
        if (metodoPagoRepository.encontrarPorNumeroTarjeta(numeroTarjeta).isPresent())
            throw new MetodoPagoAlreadyExistsException(numeroTarjeta);
        metodoPagoRepository.guardar(metodoPago);
    }

    @Override
    public MetodoPago encontrarPorId(Integer id) {
        if (id < 1) throw new InvalidIdentifierException(id);
        Optional<MetodoPago> optionalMetodoPago = metodoPagoRepository.encontrarPorId(id);
        if (optionalMetodoPago.isEmpty()) throw new MetodoPagoNotFoundException(id);
        return optionalMetodoPago.get();
    }

    @Override
    public void actualizar(MetodoPago metodoPago) {
        Integer id = metodoPago.getId();
        if (id < 1) throw new InvalidIdentifierException(id);
        if (metodoPagoRepository.encontrarPorId(id).isEmpty()) throw new MetodoPagoNotFoundException(id);
        metodoPagoRepository.actualizar(metodoPago);
    }

    @Override
    public void eliminar(Integer id) {
        if (id < 1) throw new InvalidIdentifierException(id);
        if (metodoPagoRepository.encontrarPorId(id).isEmpty()) throw new MetodoPagoNotFoundException(id);
        metodoPagoRepository.eliminar(id);
    }

    @Override
    public List<MetodoPago> encontrarTodos() {
        return metodoPagoRepository.encontrarTodos();
    }
}

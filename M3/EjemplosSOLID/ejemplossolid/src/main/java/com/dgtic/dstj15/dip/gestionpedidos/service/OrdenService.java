package com.dgtic.dstj15.dip.gestionpedidos.service;

import java.util.List;

import com.dgtic.dstj15.dip.gestionpedidos.model.Orden;
import com.dgtic.dstj15.dip.gestionpedidos.repository.OrdenRepository;

public class OrdenService {
    private OrdenRepository repository;

    public OrdenService(){
        this.repository = new OrdenRepository();
    }

    public void guardarOrden(Orden orden) {
        repository.guardarOrden(orden);
    }

    public List<Orden> getOrdenes() {
        return repository.getOrdenes();
    }

    public void borrarOrden(Orden orden) {
        repository.borrarOrden(orden);
    }

    public void actualizarOrden(Orden orden) {
        repository.actualizarOrden(orden);
    }
}

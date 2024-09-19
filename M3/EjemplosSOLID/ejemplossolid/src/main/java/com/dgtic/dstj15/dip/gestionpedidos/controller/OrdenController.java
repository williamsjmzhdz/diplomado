package com.dgtic.dstj15.dip.gestionpedidos.controller;

import java.util.List;

import com.dgtic.dstj15.dip.gestionpedidos.model.Orden;
import com.dgtic.dstj15.dip.gestionpedidos.service.OrdenService;

public class OrdenController {
    private OrdenService service;
    
    public OrdenController() {
        this.service = new OrdenService();
    }

    public void crearOrden(int id, String producto, double cantidad) {
        service.guardarOrden(new Orden(id, producto, cantidad));
    }

    public void borrarOrden(Orden orden) {
        service.borrarOrden(orden);
    }

    public List<Orden> getOrdenes() {
        return service.getOrdenes();
    }
}

package com.dgtic.dstj15.dip.gestionpedidos.repository;

import java.util.ArrayList;
import java.util.List;

import com.dgtic.dstj15.dip.gestionpedidos.model.Orden;

public class OrdenRepository {
    private List<Orden> ordenes=new ArrayList<>();

    public void guardarOrden(Orden orden) {
        ordenes.add(orden);
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void borrarOrden(Orden orden) {
        ordenes.remove(orden);
    }

    public void actualizarOrden(Orden orden) {
        ordenes.remove(orden);
        ordenes.add(orden);
    }
}

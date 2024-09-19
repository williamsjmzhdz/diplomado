package com.dgtic.dstj15.dip.gestionpedidos;

import com.dgtic.dstj15.dip.gestionpedidos.controller.OrdenController;

public class app {
    public static void main(String[] args) {
        OrdenController controller = new OrdenController();
        
        controller.crearOrden(1, "Orden Atun", 10.0);
        controller.crearOrden(2, "Orden Donas", 100);

        var ordenes=controller.getOrdenes();

        ordenes.forEach(System.out::println);
    }
}

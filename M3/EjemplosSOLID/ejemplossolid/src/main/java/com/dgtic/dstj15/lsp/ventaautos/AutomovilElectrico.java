package com.dgtic.dstj15.lsp.ventaautos;

import javax.management.RuntimeErrorException;

public class AutomovilElectrico extends AutomovilCargable {

    public AutomovilElectrico(String nombre, double precio, int kilometraje, String marca, String modelo) {
        super(nombre, precio, kilometraje, marca, modelo);
    }

    @Override
    public void apagar() {
        super.apagar();
    }

    @Override
    public void encender() {
        super.encender();
    }

    @Override
    public void cargarElectricamente() {
        System.out.println("Cargando eléctricamente.");
    }
}

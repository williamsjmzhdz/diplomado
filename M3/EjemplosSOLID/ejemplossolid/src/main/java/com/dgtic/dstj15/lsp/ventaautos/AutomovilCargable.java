package com.dgtic.dstj15.lsp.ventaautos;

public abstract class AutomovilCargable extends Automovil {

    public AutomovilCargable(String nombre, double precio, int kilometraje, String marca, String modelo) {
        super(nombre, precio, kilometraje, marca, modelo);
    }

    public abstract void cargarElectricamente();

    @Override
    public void encender() {
        super.encender();
    }

    @Override
    public void apagar() {
        super.apagar();
    }
}

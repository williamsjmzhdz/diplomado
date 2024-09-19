package com.dgtic.dstj15.lsp.ventaautos;

public class AutomovilGasolina extends AutomovilCombustion {

    public AutomovilGasolina(String nombre, double precio, int kilometraje, String marca, String modelo) {
        super(nombre, precio, kilometraje, marca, modelo);
    }

    @Override
    public void apagar() {
        super.apagar();
    }

    @Override
    public void cargarGasolina(double lts) {
        super.cargarGasolina(lts);
    }

    @Override
    public void encender() {
        super.encender();
    }
    
}

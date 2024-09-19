package com.dgtic.dstj15.lsp.ventaautos;

public class AutomovilCombustion extends Automovil {

    public AutomovilCombustion(String nombre, double precio, int kilometraje, String marca, String modelo) {
        super(nombre, precio, kilometraje, marca, modelo);
    }

    public void cargarGasolina(double lts) {
        System.out.println("Cargando gasolina...");
        System.out.println("Gasolina cargada!");
    }

    @Override
    public void apagar() {
        super.apagar();
    }

    @Override
    public void encender() {
        super.encender();
    }
}

package com.dgtic.dstj15.lsp.ventaautos;

public class app {
    public static void main(String[] args) {

        PuntoVenta puntoVenta = new PuntoVenta();
        AutomovilGasolina autoGasolina = new AutomovilGasolina("auto gasolina", 100000, 100000, "Toyota", "Corolla");
        puntoVenta.pruebaAuto(autoGasolina);

        AutomovilElectrico autoElectrico = new AutomovilElectrico("auto electrico", 100000, 100000, "Toyota", "Corolla");
        puntoVenta.pruebaAuto(autoElectrico);
    }
}

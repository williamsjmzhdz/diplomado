package com.dgtic.dstj15.ocp.procesadorpagos;

public class ProcesadorPagos {

    public void procesar(Pago pago) {
        switch (pago.tipo()) {
            case "EFECTIVO":
                procesarEfectivo(pago);
                break;
            case "CREDITO":
                procesarCredito(pago);
                break;
            default:
                break;
        }
    }

    private void procesarEfectivo(Pago pago) {
        //...
    }
    private void procesarCredito(Pago pago) {
        //...
    }

}

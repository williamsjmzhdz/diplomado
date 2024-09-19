package com.dgtic.dstj15.lsp.procesadorpagos;

public class App {
    public static void main(String[] args) {
        ProcesadorPagos app=new ProcesadorPagos();
        Pago pagoTarjetaCredito=new PagoTarjetaCredito(23.0, "1233123312331233");
        Pago pagoCripto=new PagoCripto(2.02,TipoCripto.ETH, "0x013123123123");

        app.agregarPago(pagoTarjetaCredito);
        app.agregarPago(pagoCripto);

        app.procesarPagos();
    }
}

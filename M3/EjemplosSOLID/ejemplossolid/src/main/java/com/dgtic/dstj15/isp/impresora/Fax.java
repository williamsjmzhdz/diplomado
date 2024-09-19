package com.dgtic.dstj15.isp.impresora;

public class Fax implements Imprimible, Escaneable, EnviadorFax {
    @Override
    public void escanear(Documento documento) {
        System.out.println("Escaneando doc...");
    }

    @Override
    public void enviarFax(Documento documento) {
        System.out.println("Enviado por fax el doc...");
    }

    @Override
    public void imprimir(Documento documento) {
        System.out.println("Imprimiendo doc...");
    }
}

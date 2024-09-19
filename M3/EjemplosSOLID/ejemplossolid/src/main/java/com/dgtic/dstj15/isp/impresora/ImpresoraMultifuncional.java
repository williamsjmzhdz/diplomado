package com.dgtic.dstj15.isp.impresora;

public class ImpresoraMultifuncional implements Imprimible, EnviadorFax {

    @Override
    public void imprimir(Documento documento) {
        System.out.println("Imprimiendo "+documento);
    }

    @Override
    public void escanear(Documento documento) {
        System.out.println("Escaneando "+documento);
    }
    
}

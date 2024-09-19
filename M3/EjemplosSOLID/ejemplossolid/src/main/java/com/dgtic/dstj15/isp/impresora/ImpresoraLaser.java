package com.dgtic.dstj15.isp.impresora;

public class ImpresoraLaser implements EnviadorFax, Imprimible {

    @Override
    public void imprimir(Documento documento) {
        System.out.println("Imprimiendo "+documento);
    }

    @Override
    public void escanear(Documento documento) {
        throw new UnsupportedOperationException("La impresora no soporta el escaneo");
    }
    
}

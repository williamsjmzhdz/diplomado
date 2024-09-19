package com.dgtic.dstj15.poobasicos.claseinmutable;

public final class Computadora {

    private String version;
    private String procesador;
    private int ram;
    private String uuid;

    public Computadora(){

    }

    public String obtenerVersion(){
        return version;
    }
    public int obtenerRam(){
        return ram;
    }

    public String obtenerUuid(){
        return uuid;
    }

    public String obtenerProcesador(){
        return procesador;
    }
}

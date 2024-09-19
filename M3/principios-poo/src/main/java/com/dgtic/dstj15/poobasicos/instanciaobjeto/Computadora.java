package com.dgtic.dstj15.poobasicos.instanciaobjeto;

/**
 * Computadora
 */
public class Computadora {

    public String version;
    private String procesador;
    private int ram;
    private String uuid;

    public Computadora(){

    }

    public void encender(){

    }
    public void apagar(){

    }
    public void operar(){

    }

    public String obtenerVersion(){
        return version;
    }
    public String obtenerProcesador(){
        return version;
    }
    public int obtenerRam(){
        return ram;
    }

    @Override
    public String toString() {
        return "Computadora [version=" + version + ", procesador=" + procesador + ", ram=" + ram + ", uuid=" + uuid
                + "]";
    }

    
}


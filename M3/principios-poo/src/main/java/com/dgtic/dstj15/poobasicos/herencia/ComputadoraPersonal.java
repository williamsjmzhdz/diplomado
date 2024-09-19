package com.dgtic.dstj15.poobasicos.herencia;

/**
 * ComputadoraPersonal
 */
public class ComputadoraPersonal extends Computadora{

    public ComputadoraPersonal(){
        super();
        super.procesador="IntelI9";
        super.ram=32;
        super.version="vxx012";
    }

    @Override
    public void apagar() {
        super.apagar();
    }

    @Override
    public void encender() {
        super.encender();
    }

    @Override
    public String obtenerProcesador() {
        return super.obtenerProcesador();
    }

    @Override
    public int obtenerRam() {
        return super.obtenerRam();
    }

    @Override
    public String obtenerVersion() {
        return super.obtenerVersion();
    }

    @Override
    public void operar() {
        super.operar();
    }
}
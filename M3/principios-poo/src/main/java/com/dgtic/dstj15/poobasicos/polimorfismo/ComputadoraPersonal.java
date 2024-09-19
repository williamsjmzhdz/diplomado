package com.dgtic.dstj15.poobasicos.polimorfismo;

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
        // TODO Auto-generated method stub
        super.apagar();
    }

    @Override
    public void encender() {
        // TODO Auto-generated method stub
        super.encender();
    }

    @Override
    public String obtenerProcesador() {
        // TODO Auto-generated method stub
        return super.obtenerProcesador();
    }

    @Override
    public int obtenerRam() {
        // TODO Auto-generated method stub
        return super.obtenerRam();
    }

    @Override
    public String obtenerVersion() {
        // TODO Auto-generated method stub
        return super.obtenerVersion();
    }

    @Override
    public void operar() {
        // TODO Auto-generated method stub
        super.operar();
    }
    
    
}
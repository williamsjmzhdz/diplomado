package com.dgtic.dstj15.poobasicos.interfaz;

/**
 * ComputadoraPersonal
 */
public class Mac extends Computadora{

    public Mac(){
        super();
        super.procesador="M2";
        super.ram=12;
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
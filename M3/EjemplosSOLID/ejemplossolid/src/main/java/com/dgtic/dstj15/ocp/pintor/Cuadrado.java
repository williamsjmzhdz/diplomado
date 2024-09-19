package com.dgtic.dstj15.ocp.pintor;

public class Cuadrado implements Figura {

    private final String nombreFigura = "Cuadrado";
    
    @Override
    public void pintar() {
        System.out.println("Pintando " + nombreFigura);
    }
}

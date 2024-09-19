package com.dgtic.dstj15.ocp.pintor;

public class Circulo implements Figura {

    private final String nombreFigura = "Círculo";

    @Override
    public void pintar() {
        System.out.println("Pintando " + nombreFigura);
    }

}

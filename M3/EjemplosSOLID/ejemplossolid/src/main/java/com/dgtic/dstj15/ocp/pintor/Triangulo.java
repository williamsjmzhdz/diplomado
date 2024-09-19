package com.dgtic.dstj15.ocp.pintor;

public class Triangulo implements Figura {
    private final String nombreFigura = "Triángulo";

    @Override
    public void pintar() {
        System.out.println("Pintando " + nombreFigura);
    }
}

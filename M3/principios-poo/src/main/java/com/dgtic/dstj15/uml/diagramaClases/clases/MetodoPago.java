package com.dgtic.dstj15.uml.diagramaClases.clases;

import java.util.Date;

public class MetodoPago {
    private double monto;
    private Date fecha;
    private String metodo;

    public MetodoPago(double monto, String metodo) {
        this.monto = monto;
        this.fecha = new Date();
        this.metodo = metodo;
    }

    public double obtenerMonto() {
        return monto;
    }

    public String obtenerMetodo() {
        return metodo;
    }
}
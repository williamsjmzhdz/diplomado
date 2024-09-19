package com.dgtic.dstj15.ocp.automovil.entity;

public class Automovil {
    private String marca;
    private String modelo;
    private String anio;
    private double precio;
    
    public Automovil(String marca) {
        this.marca = marca;
    }
    
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getAnio() {
        return anio;
    }
    public void setAnio(String anio) {
        this.anio = anio;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Automovil [marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", precio=" + precio + "]";
    }

    

}
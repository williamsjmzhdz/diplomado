package com.dgtic.modulo3.unidad1.procesadorpedidos;

public class Articulo {
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidadDisponible;

    public Articulo(String nombre, String categoria, double precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidadDisponible = 100;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public double obtenerPrecio() {
        return precio;
    }

    public int obtenerCantidadDisponible() {
        return cantidadDisponible;
    }

    public void restarStock() {
        cantidadDisponible--;
    }
}
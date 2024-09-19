package com.dgtic.modulo3.unidad1.procesadorpedidos;

public class ArticuloConveniencia extends Articulo {

    public ArticuloConveniencia(String nombre, String categoria,  double precio) {
        super(nombre, categoria, precio);
    }

    @Override
    public int obtenerCantidadDisponible() {
        return super.obtenerCantidadDisponible();
    }

    @Override
    public String obtenerNombre() {
        return super.obtenerNombre();
    }

    @Override
    public double obtenerPrecio() {
        return super.obtenerPrecio();
    }
    
}
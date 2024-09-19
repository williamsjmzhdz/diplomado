package com.dgtic.dstj15.lsp.ventaautos;

public class Automovil {
    private String nombre;
    private double precio;
    private int kilometraje;
    private String marca;
    private String modelo;

    public Automovil(String nombre, double precio, int kilometraje, String marca, String modelo) {
        this.nombre = nombre;
        this.precio = precio;
        this.kilometraje = kilometraje;
        this.marca = marca;
        this.modelo = modelo;
    }

    public void encender(){
        System.out.println("Encendiendo...");
    }
    public void apagar(){
        System.out.println("Apagando...");
    }
}

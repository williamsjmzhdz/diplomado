package com.dgtic.modulo3.unidad1.procesadorpedidos;

public class Direccion {
    private String calle;
    private String ciudad;
    private String estado;
    private String codigoPostal;

    public Direccion(String calle, String ciudad, String estado, String codigoPostal) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }

    public String obtenerCalle() {
        return calle;
    }

    public String obtenerCiudad() {
        return ciudad;
    }

    public String obtenerEstado() {
        return estado;
    }

    public String obtenerCodigoPostal() {
        return codigoPostal;
    }
}
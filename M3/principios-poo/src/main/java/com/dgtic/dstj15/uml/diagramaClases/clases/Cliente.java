package com.dgtic.dstj15.uml.diagramaClases.clases;

public class Cliente {

    private String nombre;
    private String apellido;
    private String id;
    private String email;
    private String celular;
    private Direccion direccion;

    public Cliente(String nombre, String apellido, String id, String email, String celular, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.email = email;
        this.celular = celular;
        this.direccion = direccion;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public String obtenerId() {
        return id;
    }

    public String obtenerEmail() {
        return email;
    }

    public String obtenerCelular() {
        return celular;
    }

    public Direccion obtenerDireccion() {
        return direccion;
    }


}

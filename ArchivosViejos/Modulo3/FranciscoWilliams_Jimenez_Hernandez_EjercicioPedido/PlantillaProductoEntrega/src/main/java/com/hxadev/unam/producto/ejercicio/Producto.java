package com.hxadev.unam.producto.ejercicio;

/**
 * Clase Producto que representa un producto en el sistema.
 * Contiene información como el nombre, precio y descripción del producto.
 *
 * @autor Alumno: Jiménez Hernández Francisco Williams
 * @fecha 19/06/2024
 */
public class Producto {
    private String nombre;
    private Double precio;
    private String descripcion;

    /**
     * Constructor para crear un nuevo producto.
     *
     * @param nombre       El nombre del producto.
     * @param precio       El precio del producto.
     * @param descripcion  Una breve descripción del producto.
     */
    public Producto(String nombre, Double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el precio del producto.
     * @return El precio del producto como un Double.
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Obtiene el nombre del producto.
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve una representación en string del producto.
     * @return El nombre del producto.
     */
    @Override
    public String toString() {
        return nombre;
    }
}

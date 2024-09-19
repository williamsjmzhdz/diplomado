package com.hxadev.unam.producto.ejercicio;

import java.util.ArrayList;

/**
 * Representa el carrito de compras de un cliente en el sistema.
 * Permite agregar y quitar productos, así como vaciar el carrito.
 *
 * @autor Alumno: Jiménez Hernández Francisco Williams
 * @fecha 19/06/2024
 */
public class Carrito {

    private ArrayList<Producto> productos;
    private Cliente cliente;

    /**
     * Constructor que inicializa un nuevo carrito para un cliente específico.
     * @param cliente El cliente asociado a este carrito.
     */
    public Carrito(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    /**
     * Agrega un producto al carrito.
     * @param producto El producto a agregar.
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto '" + producto.getNombre() +
                "' agregado al carrito de " + cliente);
    }

    /**
     * Quita un producto del carrito.
     * @param producto El producto a quitar.
     */
    public boolean quitarProducto(Producto producto) {
        if (productos.remove(producto)) {
            System.out.println("Producto '" + producto.getNombre() +
                    "' removido del carrito de " + cliente);
            return true;
        } else {
            System.out.println("Producto '" + producto.getNombre() +
                    "' no encontrado en el carrito de " + cliente);
            return false;
        }
    }

    /**
     * Vacía todos los productos del carrito.
     */
    public void vaciarCarrito() {
        productos.clear();
        System.out.println("Se vació el carrito de compras.");
    }

    /**
     * Comprueba si el carrito está vacío.
     * @return true si el carrito no tiene productos; false en caso contrario.
     */
    public boolean estaVacio() {
        return productos.isEmpty();
    }

    /**
     * Devuelve la lista de productos en el carrito.
     * @return Lista de productos.
     */
    public ArrayList<Producto> getProductos() {
        return new ArrayList<>(productos); // Retorna una copia para evitar modificaciones externas directas
    }

    /**
     * Devuelve una representación en string del carrito.
     * @return Una cadena que representa el carrito.
     */
    @Override
    public String toString() {
        return "Carrito{" +
                "cliente=" + cliente +
                ", productos=" + productos +
                '}';
    }
}

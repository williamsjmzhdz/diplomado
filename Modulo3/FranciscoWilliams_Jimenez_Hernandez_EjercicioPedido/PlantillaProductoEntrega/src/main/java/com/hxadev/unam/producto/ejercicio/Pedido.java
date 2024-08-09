package com.hxadev.unam.producto.ejercicio;

import java.util.ArrayList;
import java.util.Date;

/**
 * Representa un pedido en el sistema.
 * Gestiona los detalles y el estado de los pedidos del sistema.
 *
 * @autor Alumno: Jiménez Hernández Francisco Williams
 * @fecha 19/06/2024
 */
public class Pedido {
    private int numeroPedido;
    private Date fecha;
    private double total;
    private EstadoPedido estado;
    private ArrayList<Producto> productos;
    private Cliente cliente;

    /**
     * Constructor para inicializar un Pedido con un total, una lista de productos y un cliente.
     * Asigna un número de pedido aleatorio, la fecha actual y el estado NO_PAGADO.
     *
     * @param total El precio total de la compra
     * @param productos La lista de productos asociados al pedido
     * @param cliente El cliente asociado al pedido
     */
    public Pedido(double total, ArrayList<Producto> productos, Cliente cliente) {
        this.numeroPedido = (int) (Math.random() * 999999999 + 1);
        this.fecha = new Date();
        this.productos = productos;
        this.cliente = cliente;
        this.total = total;
        this.estado = EstadoPedido.NO_PAGADO;

        System.out.println("Pedido generado con éxito. \n\t" +
                "Cliente: " + cliente + "\n\t" +
                "Número de pedido: " + numeroPedido + "\n\t" +
                "Total del pedido: " + total);
    }

    /**
     * Devuelve una lista de los productos en el pedido.
     *
     * @return Una copia de la lista de productos para evitar modificaciones externas.
     */
    public ArrayList<Producto> getProductos() {
        return new ArrayList<>(productos); // Devuelve una copia para evitar modificaciones externas
    }

    /**
     * Devuelve el total del pedido.
     *
     * @return El total del pedido.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Devuelve el estado del pedido.
     *
     * @return El estado del pedido.
     */
    public EstadoPedido getEstado() {
        return estado;
    }

    /**
     * Cambiar el estado del pedido
     *
     * @param estado El nuevo estado del pedido.
     */
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    /**
     * Devuelve el número de pedido.
     *
     * @return El número de pedido
     */
    public int getNumeroPedido() {
        return numeroPedido;
    }

    /**
     * Devuelve el cliente del pedido
     *
     * @return El cliente del pedido
     */
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numeroPedido=" + numeroPedido +
                ", fecha=" + fecha +
                ", total=" + total +
                ", estado=" + estado +
                ", productos=" + productos +
                ", cliente=" + cliente +
                '}';
    }
}

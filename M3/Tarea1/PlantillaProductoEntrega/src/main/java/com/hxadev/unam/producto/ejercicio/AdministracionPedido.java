package com.hxadev.unam.producto.ejercicio;

/**
 * Interfaz EstadoPedido que define las operaciones básicas para gestionar los estados de un pedido.
 *
 * @autor Alumno: Jiménez Hernández Francisco Williams
 * @fecha 19/06/2024
 * */
public interface AdministracionPedido {

    /**
     * Paga un pedido. Método abstracto.
     */
    boolean pagarPedido(Pedido pedido);

    /**
     * Cancela un pedido. Método abstracto.
     */
    boolean cancelarPedido(Pedido pedido);
}

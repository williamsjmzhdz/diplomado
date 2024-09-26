package com.hxadev.unam.producto.ejercicio;

import java.util.Date;

/**
 * Clase PagoTarjeta que extiende de la clase Pago para especializarla en pagos con tarjeta.
 * Esta clase gestiona los detalles específicos de los pagos realizados mediante tarjetas de crédito o débito.
 *
 * @autor Alumno: Jiménez Hernández Francisco Williams
 * @fecha 19/06/2024
 */
public class Tarjeta extends MetodoPago {

    private String numeroTarjeta;

    /**
     * Constructor para crear una instancia de PagoTarjeta.
     * @param numeroTarjeta Número de la tarjeta de crédito o débito utilizada para el pago.
     * @param cliente       Cliente asociado con este pago.
     * @param monto         Monto del pago.
     * @param tipo        Tipo del método de pago "Crédito", "Débito", etc.
     */
    public Tarjeta(String numeroTarjeta, Cliente cliente, double monto, String tipo, Date fechaExpiracion) {
        super(cliente, monto, tipo, fechaExpiracion);
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Realiza el pago del pedido con una tarjeta.
     * @param monto Monto del pago.
     */
    @Override
    public boolean realizarPago(double monto) {
        System.out.println("Pago con tarjeta. Número de tarjeta: " + numeroTarjeta);
        return super.realizarPago(monto);
    }

    /**
     * Proporciona una representación en string de una tarjeta.
     * @return Una cadena que representa el objeto PagoTarjeta.
     */
    @Override
    public String toString() {
        return "Tarjeta{" +
                "numeroTarjeta='" + numeroTarjeta + '\'' +
                "} " + super.toString();
    }
}

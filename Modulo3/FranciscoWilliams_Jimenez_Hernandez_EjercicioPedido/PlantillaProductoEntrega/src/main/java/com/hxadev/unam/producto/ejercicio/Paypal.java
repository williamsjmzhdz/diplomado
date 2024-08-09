package com.hxadev.unam.producto.ejercicio;

import java.util.Date;

/**
 * Clase Paypal que extiende de la clase MetodoPago para pagos realizados a través de PayPal.
 *
 * @autor Alumno: Jiménez Hernández Francisco Williams
 * @fecha 19/06/2024
 */
public class Paypal extends MetodoPago {

    private String emailPaypal;

    /**
     * Constructor para crear una instancia de Paypal.
     *
     * @param emailPaypal Email asociado a la cuenta de PayPal del cliente.
     * @param cliente     Cliente que realiza el pago.
     * @param monto       Monto del pago.
     * @param tipo      Tipo del método de pago "Crédito", "Débito", etc.
     */
    public Paypal(String emailPaypal, Cliente cliente, double monto, String tipo, Date fechaExpiracion) {
        super(cliente, monto, tipo, fechaExpiracion);
        this.emailPaypal = emailPaypal;
    }

    /**
     * Realiza el pago del pedido con Paypal.
     * @param monto Monto del pago.
     */
    @Override
    public boolean realizarPago(double monto) {
        System.out.println("Pago con Paypal. Email: " + emailPaypal);
        return super.realizarPago(monto);
    }

    /**
     * Devuelve una representación en string de la instancia de Paypal.
     * y la información del método de pago heredada de la clase MetodoPago.
     * @return Una cadena que representa el objeto PagoPaypal, incluyendo detalles del pago y el email de PayPal.
     */
    @Override
    public String toString() {
        return "Paypal{" +
                "emailPaypal='" + emailPaypal + '\'' +
                "} " + super.toString();
    }
}

package com.hxadev.unam.producto.ejercicio;

import java.util.Date;

/**
 * Clase abstracta MetodoPago que representa un método de pago.
 *
 * @autor Alumno: Jiménez Hernández Francisco Williams
 * @fecha 19/06/2024
 */
public abstract class MetodoPago {
    private double monto;
    private Date fechaExpiracion;
    private String tipo;
    private Cliente cliente;

    /**
     * Constructor para inicializar un pago.
     *
     * @param cliente El cliente asociado al pago.
     * @param monto El monto inicial asociado al pago.
     * @param tipo El tipo de pago utilizado (e.g., débito, crédito).
     */
    public MetodoPago(Cliente cliente, double monto, String tipo, Date fechaExpiracion) {
        if(cliente == null) {
            System.out.println("No se puede crear un método de pago sin cliente asignado.");
        } else {
            this.cliente = cliente;
            this.monto = monto;
            this.fechaExpiracion = fechaExpiracion;
            this.tipo = tipo;
        }
    }

    /**
     * Realiza un pago si el monto es positivo y suficiente para cubrir el pago solicitado.
     * @param monto El monto a pagar.
     */
    public boolean realizarPago(double monto) {
        if (monto < 0) {
            System.out.println("Error al realizar pago: Monto negativo.");
            return false;
        }

        if (monto > this.monto) {
            System.out.println("Error al realizar pago: Fondos insuficientes.");
            return false;
        }

        setMonto(this.monto - monto);
        System.out.println("Pago de $" + monto + " realizado con éxito. Monto restante: $" + this.monto);
        return true;
    }

    /**
     * Recarga un saldo adicional al saldo actual del método de pago.
     *
     * @param saldo El saldo a recargar.
     */
    public void recargarSaldo(double saldo) {
        if (monto < 0) {
            System.out.println("Error al depositar: Monto negativo.");
            return;
        }

        setMonto(this.monto + saldo);
        System.out.println("Saldo de $" + saldo  + " depositado con éxito. Nuevo saldo: $" + this.monto);
    }

    /**
     * Establece el monto del método de pago.
     *
     * @param monto El nuevo monto a establecer.
     */
    private void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Devuelve el monto del método de pago
     *
     * @return El monto del método de pago
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Devuelve una representación en string de un método de pago.
     * @return Una cadena que representa el método de pago.
     */
    @Override
    public String toString() {
        return "MetodoPago{" +
                "monto=" + monto +
                ", fecha=" + fechaExpiracion +
                ", metodo='" + tipo + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}

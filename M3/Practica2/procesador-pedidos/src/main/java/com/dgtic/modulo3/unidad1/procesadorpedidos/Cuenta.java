package com.dgtic.modulo3.unidad1.procesadorpedidos;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private Cliente cliente;
    private double saldo;
    private List<MetodoPago> transacciones;

    public Cuenta(Cliente cliente){
        this.cliente = cliente;
        saldo = 0;
        transacciones = new ArrayList<MetodoPago>();
    }

    public double obtenerSaldo() {
        return saldo;
    }

    public void agregarTransaccion(MetodoPago transaccion) {
        transacciones.add(transaccion);
        saldo += transaccion.obtenerMonto();
    }

    public List<MetodoPago> obtenerTransacciones() {
        return transacciones;
    }

    public Cliente obtenerCliente() {
        return cliente;
    }
}
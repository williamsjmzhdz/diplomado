package com.dgtic.dstj15.lsp.procesadorpagos;

public abstract class Pago {
    protected double monto;

    public Pago(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public abstract void procesarPago();

    public abstract void devolverPago();
}

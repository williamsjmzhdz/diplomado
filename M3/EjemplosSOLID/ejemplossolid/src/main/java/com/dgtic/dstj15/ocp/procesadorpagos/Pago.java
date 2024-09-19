package com.dgtic.dstj15.ocp.procesadorpagos;

public record Pago(
    String tipo,
    double monto,
    String banco,
    String numeroCuenta,
    String nombreTitular
) {
    
}

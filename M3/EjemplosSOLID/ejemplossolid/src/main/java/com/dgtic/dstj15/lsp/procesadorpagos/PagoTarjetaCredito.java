package com.dgtic.dstj15.lsp.procesadorpagos;

public class PagoTarjetaCredito extends Pago{

    private String numeroTarjeta;

    public PagoTarjetaCredito(double monto, String numeroTarjeta){
        super(monto);
        this.numeroTarjeta = numeroTarjeta;
    }
    @Override
    public void procesarPago() {
        System.out.println("Procesando pago con tarjeta...");
        System.out.println("Pago procesado... "+numeroTarjeta);
        // Logica para procesar pagos con tarjeta.
        
    }
    @Override
    public void devolverPago() {
        System.out.println("Procesando devolver");
        System.out.println("Devolucion completada...");
        
    }
    
    
}

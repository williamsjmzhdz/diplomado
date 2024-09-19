package com.dgtic.dstj15.lsp.procesadorpagos;

public class PagoCripto extends Pago{

    private String direccionBilletera;
    private TipoCripto tipo;

    public PagoCripto(double monto, TipoCripto tipo, String direccionBilletera){
        super(monto);
        this.direccionBilletera = direccionBilletera;
        this.tipo=tipo;
    }

    @Override
    public void procesarPago() {
        System.out.println("Procesando pago cripto");
        System.out.println("Pago procesado "+tipo.name());
    }

    @Override
    public void devolverPago() {
       throw new UnsupportedOperationException("No es posible realizar devoluciones para este metodo de pago.");
        
    }

    


    
}

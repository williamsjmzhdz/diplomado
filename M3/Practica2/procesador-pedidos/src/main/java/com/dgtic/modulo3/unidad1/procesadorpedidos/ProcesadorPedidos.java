package com.dgtic.modulo3.unidad1.procesadorpedidos;

public class ProcesadorPedidos implements Procesador {

    @Override
    public void procesar(Pedido pedido) throws Exception {
        pedido.realizarPedido();
    }
    
}

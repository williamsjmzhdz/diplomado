package com.dgtic.dstj15.uml.diagramaClases.clases;

public class ProcesadorPedidos implements Procesador {

    @Override
    public void procesar(Pedido pedido) throws Exception {
        pedido.realizarPedido();
    }
    
}

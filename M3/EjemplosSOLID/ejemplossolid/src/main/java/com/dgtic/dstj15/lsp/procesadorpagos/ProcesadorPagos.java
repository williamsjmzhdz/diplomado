package com.dgtic.dstj15.lsp.procesadorpagos;

import java.util.ArrayList;
import java.util.List;

public class ProcesadorPagos {
    private List<Pago> pagos;

    public ProcesadorPagos() {
        this.pagos = new ArrayList<>();
    }

    public void agregarPago(Pago pago) {
        pagos.add(pago);
    }

    public void procesarPagos() {
        pagos.stream().forEach(pago -> pago.procesarPago());
    }
}

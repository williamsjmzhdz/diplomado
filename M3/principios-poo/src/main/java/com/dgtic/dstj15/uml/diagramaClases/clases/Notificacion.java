package com.dgtic.dstj15.uml.diagramaClases.clases;

import java.util.Date;

public class Notificacion {
    private String tipo;
    private Date fecha;
    private String origen;
    private String destino;
    private String canal;
    private String estatus;

    public Notificacion(String origen, String destino){
        this.estatus="CREADO";
        this.tipo = "SMS";
        this.origen = origen;
        this.destino = destino;
        this.canal = "8989";
    }

    public void enviarNotificacion() throws Exception {
        this.estatus="PROCESANDO";
        this.logNotificacion();
        Thread.sleep(2000);
        this.estatus = "ENVIADO";
        this.fecha = new Date();
        this.logNotificacion();
        System.out.println("Notificación enviada a: " + this.destino + " por el canal: " + this.canal);
    }

    private String estatusNotificacion() {
        return estatus;
    }

    private void logNotificacion() {
    }
}
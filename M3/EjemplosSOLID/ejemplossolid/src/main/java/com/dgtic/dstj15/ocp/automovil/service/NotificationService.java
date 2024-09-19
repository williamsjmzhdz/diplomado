package com.dgtic.dstj15.ocp.automovil.service;

public class NotificationService {
    public void enviarNotificacion(Notificacion notificacion) {
        notificacion.enviar();
    }
}

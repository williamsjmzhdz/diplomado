package com.dgtic.dstj15.srp.automovil.service;

public class NotificacionServiceImpl implements NotificacionService {
    @Override
    public void enviarNotificacion(String datos) {
        System.out.println("Enviando notificación...");
        System.out.println("Notificación enviada con éxito.");
    }
}

package com.unam.dgtic.observer;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class EmergencyNotificationSystem implements HealthObserver{
    private String systemName;


    public EmergencyNotificationSystem(String systemName) {
        this.systemName = systemName;
    }

    @Override
    public void update(String message) {
        System.out.println(systemName+" received notification: "+message);
        // Aqui podria existir una conexion con algun protocolo de eventos y mensajes que permitan enviar la notificacion al dispositivo del sistema de emergencia.
    }
}

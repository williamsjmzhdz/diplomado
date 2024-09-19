package com.unam.dgtic.observer;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class PatientDevice implements HealthObserver{
    private String deviceName;

    public PatientDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void update(String message) {
        System.out.println(deviceName+": Health Notification: "+message);
        // Aqui podria existir una conexion con algun protocolo de eventos y mensajes que permitan enviar la notificacion al dispositivo del paciente.
    }
}

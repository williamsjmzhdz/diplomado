package com.unam.dgtic.observer;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class DoctorDevice implements HealthObserver{
    private String deviceName;
    private String patientId;

    public DoctorDevice(String patientId,String deviceName) {
        this.deviceName = deviceName;
        this.patientId=patientId;
    }

    @Override
    public void update(String message) {
        System.out.println(deviceName+": Health Notification about patient "+patientId+": Message: "+message);
        // Aqui podria existir una conexion con algun protocolo de eventos y mensajes que permitan enviar la notificacion al dispositivo del doctor.
    }
}

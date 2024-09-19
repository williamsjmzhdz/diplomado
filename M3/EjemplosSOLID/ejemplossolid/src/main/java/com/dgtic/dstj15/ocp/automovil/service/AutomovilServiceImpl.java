package com.dgtic.dstj15.ocp.automovil.service;

import com.dgtic.dstj15.ocp.automovil.entity.Automovil;
import com.dgtic.dstj15.ocp.automovil.repository.AutomovilRepository;

public class AutomovilServiceImpl implements AutomovilService {

    private AutomovilRepository automovilRepository;
    private NotificationService notificationService;

    public AutomovilServiceImpl() {
    }

    public AutomovilServiceImpl(AutomovilRepository automovilRepository) {
        this.automovilRepository = automovilRepository;
        this.notificationService = new NotificationService();
    }

    @Override
    public void arrancarMotor(Automovil automovil) {
        System.out.println("Arrancado!");
        Notificacion notificacionWhatsapp = new NotificacionWhatsapp();
        notificationService.enviarNotificacion(notificacionWhatsapp);
    }

    @Override
    public void acelerar(Automovil automovil) {
        System.out.println("Acelerando!! Run run!");

    }

    @Override
    public void frenar(Automovil automovil) {
        System.out.println("Automovil frenado");
        Notificacion notificacionSMS = new NotificacionSMS();
        notificationService.enviarNotificacion(notificacionSMS);
    }

    @Override
    public void mostrarInformacion(Automovil automovil) {
        System.out.println(automovilRepository.cargarAutoBD(automovil.getMarca()).toString());
    }

    

}

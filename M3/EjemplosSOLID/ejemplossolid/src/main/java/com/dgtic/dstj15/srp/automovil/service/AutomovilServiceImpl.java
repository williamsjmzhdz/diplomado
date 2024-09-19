package com.dgtic.dstj15.srp.automovil.service;

import java.util.List;

import com.dgtic.dstj15.srp.automovil.entity.Automovil;
import com.dgtic.dstj15.srp.automovil.repository.AutomovilRepository;

public class AutomovilServiceImpl implements AutomovilService {

    private List<Automovil> automoviles;
    private NotificacionService notificacionService;
    private AutomovilRepository automovilRepository;
    
    public AutomovilServiceImpl() {
        this.automoviles = List.of(
            new Automovil("Tesla"),
            new Automovil("Jeep"),
            new Automovil("Mazda"));
        notificacionService = new NotificacionServiceImpl();
    }

    @Override
    public void arrancarMotor(Automovil automovil) {
        System.out.println("Arrancado!");
        notificacionService.enviarNotificacion("Automovil arrancado!");
    }

    @Override
    public void acelerar(Automovil automovil) {
        System.out.println("Acelerando!! Run run!");

    }

    @Override
    public void frenar(Automovil automovil) {
        System.out.println("Automovil frenado");
        notificacionService.enviarNotificacion("Frenando automovil!");
    }

    @Override
    public void mostrarInformacion(Automovil automovil) {
        System.out.println(automovilRepository.cargarAutoBD(automovil.getMarca()).toString());
    }

    /**
    public void guardarAutomovilBD(Automovil auto) {
        this.automoviles.add(auto);
    }

    public Automovil cargarAutoBD(String marca) {
        return this.automoviles.stream().filter(auto -> auto.getMarca().equals(marca)).findFirst()
                .orElseThrow(NullPointerException::new);
    }
     */

    

}

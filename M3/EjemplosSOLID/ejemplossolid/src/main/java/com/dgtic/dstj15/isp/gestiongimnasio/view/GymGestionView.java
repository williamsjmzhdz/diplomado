package com.dgtic.dstj15.isp.gestiongimnasio.view;

import java.util.ArrayList;
import java.util.List;

import com.dgtic.dstj15.isp.gestiongimnasio.controller.GymGestionController;
import com.dgtic.dstj15.isp.gestiongimnasio.model.Cliente;
import com.dgtic.dstj15.isp.gestiongimnasio.model.Entrenador;
import com.dgtic.dstj15.isp.gestiongimnasio.model.GymMiembro;

public class GymGestionView {
    private List<GymMiembro> miembros = new ArrayList<>();
    private GymGestionController controller;

    public GymGestionView() {
        miembros.add(new Cliente());
        miembros.add(new Entrenador());

        controller = new GymGestionController();
    }

    public void iniciar() {
        miembros
                .stream().forEach(miembro -> {
                    controller.agregarMiembro(miembro);
                });
                
        controller.reservarClase("Natacion");
        controller.consultarPlanesEntrenamiento();
        controller.pagarMembresia(20.0);
        controller.brindarPlanEntrenamiento();
    }
}

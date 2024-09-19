package com.dgtic.dstj15.isp.gestiongimnasio.controller;

import java.util.ArrayList;
import java.util.List;

import com.dgtic.dstj15.isp.gestiongimnasio.model.GymMiembro;

public class GymGestionController {
    
    private List<GymMiembro> miembros;

    public GymGestionController() { 
        this.miembros=new ArrayList<>();
    }

    public void agregarMiembro(GymMiembro miembro) {
        miembros.add(miembro);
    }

    public void reservarClase(String clase) {
        miembros.stream().forEach(miembro->miembro.reservarClase(clase));
    }

    public void consultarPlanesEntrenamiento() {
        miembros.stream().forEach(miembro->miembro.consultarPlanEntrenamiento());
    }


    public void pagarMembresia(double monto) {
        miembros.stream().forEach(miembro->miembro.pagarMembresia(monto));
    }

    public void brindarPlanEntrenamiento() {
        miembros.stream().forEach(miembros->miembros.brindarPlanEntrenamiento());
    }
}

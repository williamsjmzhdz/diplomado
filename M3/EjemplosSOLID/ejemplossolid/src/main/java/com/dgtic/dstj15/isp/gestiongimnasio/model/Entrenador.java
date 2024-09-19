package com.dgtic.dstj15.isp.gestiongimnasio.model;

public class Entrenador implements GeneradorPlanEntrenamiento, ConsultarPlan {

    @Override
    public void brindarPlanEntrenamiento() {
        System.out.println("Escribiendo plan entrenamiento");
        
    }

    @Override
    public void consultarPlanEntrenamiento() {
        System.out.println("Consultando plan de entrenamiento");
        
    }

}

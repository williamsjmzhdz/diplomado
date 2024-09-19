package com.dgtic.dstj15.ocp.automovil.service;

import com.dgtic.dstj15.ocp.automovil.entity.Automovil;

public interface AutomovilService {
    public void arrancarMotor(Automovil automovil);

    public void acelerar(Automovil automovil);

    public void frenar(Automovil automovil);

    public void mostrarInformacion(Automovil automovil);
}

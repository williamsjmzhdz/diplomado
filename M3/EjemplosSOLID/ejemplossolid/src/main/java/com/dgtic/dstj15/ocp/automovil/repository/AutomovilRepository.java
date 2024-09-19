package com.dgtic.dstj15.ocp.automovil.repository;

import com.dgtic.dstj15.ocp.automovil.entity.Automovil;

public interface AutomovilRepository {
    public void guardarAutomovilBD(Automovil auto);
    public Automovil cargarAutoBD(String marca);
}

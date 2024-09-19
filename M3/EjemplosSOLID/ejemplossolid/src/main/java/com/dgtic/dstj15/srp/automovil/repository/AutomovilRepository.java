package com.dgtic.dstj15.srp.automovil.repository;

import com.dgtic.dstj15.srp.automovil.entity.Automovil;

public interface AutomovilRepository {

    public void guardarAutomovilBD(Automovil auto);

    public Automovil cargarAutoBD(String marca);
}

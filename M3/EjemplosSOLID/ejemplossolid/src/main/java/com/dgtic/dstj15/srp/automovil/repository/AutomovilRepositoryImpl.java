package com.dgtic.dstj15.srp.automovil.repository;

import com.dgtic.dstj15.srp.automovil.entity.Automovil;
import com.dgtic.dstj15.srp.automovil.service.AutomovilServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class AutomovilRepositoryImpl implements AutomovilRepository {


    List<Automovil> automoviles;

    public void AutomovilServiceImpl() {
        automoviles = new ArrayList<>();
    }

    @Override
    public void guardarAutomovilBD(Automovil auto) {
        automoviles.add(auto);
    }

    @Override
    public Automovil cargarAutoBD(String marca) {

        return this.automoviles.stream().filter(auto -> auto.getMarca().equals(marca)).findFirst()
                .orElseThrow(NullPointerException::new);

    }
}

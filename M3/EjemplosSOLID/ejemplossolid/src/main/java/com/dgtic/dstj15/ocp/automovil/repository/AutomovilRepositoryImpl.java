package com.dgtic.dstj15.ocp.automovil.repository;

import java.util.List;

import com.dgtic.dstj15.ocp.automovil.entity.Automovil;

public class AutomovilRepositoryImpl implements AutomovilRepository {

    private List<Automovil> automoviles;

    public AutomovilRepositoryImpl() {
        this.automoviles = List.of(new Automovil("Tesla"), new Automovil("Mazda"));
    }

    @Override
    public void guardarAutomovilBD(Automovil auto) {
        // Se guarda o actualiza el Automovil en la base de datos
        this.automoviles.add(auto);
    }

    @Override
    public Automovil cargarAutoBD(String marca) {
        // Se obtiene el automovil dde la base de datos
        return this.automoviles.stream().filter(auto -> auto.getMarca().equals(marca)).findFirst()
                .orElseThrow(NullPointerException::new);
    }

}

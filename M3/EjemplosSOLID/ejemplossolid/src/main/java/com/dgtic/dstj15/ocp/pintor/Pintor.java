package com.dgtic.dstj15.ocp.pintor;

import java.util.Collection;

public class Pintor {

    void pinta(Collection<Figura> figuras) {
        for (Figura figura : figuras) {
            figura.pintar();
        }
    }
}
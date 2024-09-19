package com.dgtic.dstj15.poobasicos.instanciaobjeto;

import java.util.List;
import com.dgtic.dstj15.poobasicos.clase.Computadora;

public class Cluster {
    Computadora cc01;
    private Computadora cc02;
    private List<Computadora> cst01;

    public Cluster(){
        cc01=new Computadora();
        cc02=new Computadora();
        cst01.add(cc01);
        cst01.add(cc02);
    }
}

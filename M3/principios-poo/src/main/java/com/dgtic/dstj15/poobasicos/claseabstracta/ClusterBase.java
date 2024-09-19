package com.dgtic.dstj15.poobasicos.claseabstracta;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class ClusterBase{
    protected List<Computadora> nodos;
    protected boolean estaActivo;
    protected Date fechaReinicio;

    protected ClusterBase(){
        this.nodos=new ArrayList<>();
        this.estaActivo=false;
        this.fechaReinicio=new Date();
    }

    protected void activarCluster(){
        this.estaActivo=true;
    }

    protected void reiniciar(){
        estaActivo=false;
        fechaReinicio=new Date();
        estaActivo=true;
    }

    abstract void agregarNodos();
    abstract void limpiarNodos();

}

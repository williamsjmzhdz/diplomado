package com.dgtic.dstj15.poobasicos.interfaz;

public class Cluster implements ClusterService{
    private Computadora cc01;
    private Computadora cc02;
    private boolean active;

    public Cluster(){
        // Polimorfismo a su maxima expresion
        this.cc01=new ComputadoraPersonal();
        this.cc02=new Mac();
    }


    @Override
    public Computadora getFirstComputer() {
        return cc01;
    }


    @Override
    public Computadora getSecondComputer() {
        return cc02;
    }


    @Override
    public boolean isClusterActive() {
        return active && cc01!=null;
    }


}

package com.dgtic.dstj15.poobasicos.polimorfismo;

public class Cluster {
    private Computadora cc01;
    private Computadora cc02;


    public Cluster(){
        // Polimorfismo a su maxima expresion
        this.cc01=new ComputadoraPersonal();
        this.cc02=new Mac();
    }

    public Computadora getFirstComputer(){
        return cc01;
    }
    public Computadora getSecondComputer(){
        return cc02;
    }
}

package com.dgtic.dstj15.poobasicos.herencia;

public class Cluster {
    private Computadora cc01;
    private Computadora cc02;


    public Cluster(){
        this.cc01=new Computadora();
        this.cc02=new Computadora();

    }

    public Computadora getFirstComputer(){
        return cc01;
    }
    public Computadora getSecondComputer(){
        return cc02;
    }
}

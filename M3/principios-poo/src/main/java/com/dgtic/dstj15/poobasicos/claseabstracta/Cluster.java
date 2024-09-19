package com.dgtic.dstj15.poobasicos.claseabstracta;

public class Cluster extends ClusterBase implements ClusterService{
    private Computadora cc01;
    private Computadora cc02;
    private boolean active;

    public Cluster(){
        super();
    }

    @Override
    public Computadora getFirstComputer() {
        return super.nodos.get(0);
    }
    @Override
    public Computadora getSecondComputer() {
        return super.nodos.get(1);
    }
    @Override
    public boolean isClusterActive() {
        return active;
    }
    @Override
    void agregarNodos() {
        super.nodos.add(cc01);
        super.nodos.add(cc02);
    }
    @Override
    void limpiarNodos() {
        super.nodos.clear();
    }


}

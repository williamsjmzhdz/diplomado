package com.dgtic.dstj15.poobasicos.modificadoresacceso;

import java.util.List;
import java.util.Vector;

public class ClusterV2 {

    private List<Computadora> cst01;

    public ClusterV2(){
        cst01=new Vector<>();
    }

    public void addNode(Computadora cc){
        cst01.add(cc);
    }

    public List<Computadora> getNodes(){
        return cst01;
    }

    public void displayNodes(){
        cst01.stream().forEach(System.out::println);
    }
}

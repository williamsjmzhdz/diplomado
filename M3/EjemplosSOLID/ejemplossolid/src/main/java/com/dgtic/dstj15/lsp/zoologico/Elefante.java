package com.dgtic.dstj15.lsp.zoologico;

import javax.management.RuntimeErrorException;

public class Elefante extends Animal {

    @Override
    public void caminar() {
       System.out.println("Elefante caminando!");
    }

    @Override
    public void brincar() {
        throw new RuntimeErrorException(null,"No puedo brincar :v");
    }

    @Override
    public void correr() {
        System.out.println("Elefante corriendo!");
    }
    
}

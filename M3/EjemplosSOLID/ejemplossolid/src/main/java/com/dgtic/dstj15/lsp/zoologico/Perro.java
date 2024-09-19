package com.dgtic.dstj15.lsp.zoologico;

public class Perro extends AnimalLigero {

    @Override
    public void caminar() {
        System.out.println("Perro Caminando!");
    }

    @Override
    public void brincar() {
        System.out.println("Perro brincando! Jump!");

    }

    @Override
    public void nadar() {
        System.out.println("Perro nadando!");

    }

    @Override
    public void correr() {
        System.out.println("Perro corriendo!");
    }
    
}

package com.dgtic.dstj15;

import com.dgtic.dstj15.handlers.BaseSupportHandler;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 **/
public class Main {
    public static void main(String[] args) {

        BaseSupportHandler basicSupport = new BasicSupportHandler();
        BaseSupportHandler middleSupport = new IntermediateSupportHandler();
        BaseSupportHandler advancedSupport = new AdvancedSupportHandler();

        basicSupport.setNext(middleSupport);
        middleSupport.setNext(advancedSupport);

        System.out.println("Basic Support handling the request");
        basicSupport.handle("BASIC");




    }
}
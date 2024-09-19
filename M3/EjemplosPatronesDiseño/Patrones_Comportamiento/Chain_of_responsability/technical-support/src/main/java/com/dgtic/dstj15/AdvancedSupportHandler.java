package com.dgtic.dstj15;

import com.dgtic.dstj15.handlers.BaseSupportHandler;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 **/
public class AdvancedSupportHandler extends BaseSupportHandler{

    @Override
    public void handle(Object request) {
        if(request.toString().equalsIgnoreCase("ADVANCED")){
            System.out.println("Advanced Support handling the request");
            System.out.println("Request handled! 😃");
        }else{
            System.out.println("Advanced Support can't handle the request");
            System.out.println("Request could not be handled! 😢");
        }
    }
    
}

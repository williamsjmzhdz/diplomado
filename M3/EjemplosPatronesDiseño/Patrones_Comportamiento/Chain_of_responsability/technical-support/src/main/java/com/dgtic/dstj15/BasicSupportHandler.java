package com.dgtic.dstj15;

import com.dgtic.dstj15.handlers.BaseSupportHandler;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 **/
public class BasicSupportHandler extends BaseSupportHandler{

    @Override
    public void handle(Object request) {
        if(request.toString().equalsIgnoreCase("BASIC")){
            System.out.println("Basic Support handling the request 👌🏻");
        }else{
            System.out.println("Basic Support can't handle the request");
            System.out.println("Passing on the request to next handler ⏭️");
            super.handle(request);
        }
    }
    
}

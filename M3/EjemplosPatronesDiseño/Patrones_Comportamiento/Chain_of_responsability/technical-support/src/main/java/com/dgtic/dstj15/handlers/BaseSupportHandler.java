package com.dgtic.dstj15.handlers;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 **/
public abstract class BaseSupportHandler implements SupportHandler {

    protected SupportHandler nextHandler;

    @Override
    public void handle(Object request) {
        if(request!=null){
            nextHandler.handle(request);
        }
        
    }

    @Override
    public void setNext(SupportHandler handler) {
        this.nextHandler = handler;
        
    }
    
}

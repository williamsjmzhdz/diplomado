package com.dgtic.dstj15.handlers;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 **/
public interface SupportHandler {
    void setNext(SupportHandler handler);
    void handle(Object request);
}

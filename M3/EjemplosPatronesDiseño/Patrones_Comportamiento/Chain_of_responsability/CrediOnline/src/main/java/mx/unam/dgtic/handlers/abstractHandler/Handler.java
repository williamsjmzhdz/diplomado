package mx.unam.dgtic.handlers.abstractHandler;

import mx.unam.dgtic.model.Request;
import mx.unam.dgtic.model.User;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public interface Handler {
    boolean authenticate(User user, Request request);
    boolean authorize(User user, Request request);
     boolean processRequest(User user, Request request);
     boolean hasNextHandler();
     boolean delegateNextHandler(User user, Request request);
     void setNextHandler(Handler nextHandler);
}

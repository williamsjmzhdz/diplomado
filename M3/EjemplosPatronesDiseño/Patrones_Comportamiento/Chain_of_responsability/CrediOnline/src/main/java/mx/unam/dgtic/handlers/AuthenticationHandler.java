package mx.unam.dgtic.handlers;

import mx.unam.dgtic.handlers.abstractHandler.AbstractHandler;
import mx.unam.dgtic.model.Request;
import mx.unam.dgtic.model.User;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class AuthenticationHandler extends AbstractHandler {
    @Override
    public boolean authenticate(User user, Request request) {
        printStatus("AuthenticationHandler: Authenticate...");
        // Aqui deberia de estar alguna conexion en la base de datos o conexion con algun servicio de autenticacion como Auth0 o Firebase.
        return (user.getEmail().equals("persona123@gmail.com") && user.getPassword().equals("admin123"));
    }

    @Override
    public boolean authorize(User user, Request request) {
        printStatus("AuthenticationHandler: Authorize...");
        return delegateNextHandler(user, request);
    }

    @Override
    protected void printStatus(String message) {
        System.out.println(message);
    }
}

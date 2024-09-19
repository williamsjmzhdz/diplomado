package mx.unam.dgtic.handlers;

import mx.unam.dgtic.handlers.abstractHandler.AbstractHandler;
import mx.unam.dgtic.model.Request;
import mx.unam.dgtic.model.User;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class CreditBalanceHandler extends AbstractHandler {
    @Override
    public boolean authenticate(User user, Request request) {
        printStatus("CreditBalanceHandler: Authenticate...");
        return (user.getCreditLimit() > request.getAmount());
    }

    @Override
    public boolean authorize(User user, Request request) {
        printStatus("CreditBalanceHandler: Authorize...");
        if(user.getCreditLimit() > request.getAmount() && user.getEmail().equals("persona123@gmail.com")){
            return delegateNextHandler(user, request);
        }else
            return false;
    }

    @Override
    protected void printStatus(String message) {
        System.out.println("CreditBalanceHandler:"+message);
    }
}

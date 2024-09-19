package mx.unam.dgtic.handlers.abstractHandler;

import mx.unam.dgtic.model.Request;
import mx.unam.dgtic.model.User;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public abstract class AbstractHandler implements Handler {
    private Handler nextHandler;

    @Override
    public abstract boolean authenticate(User user, Request request);

    @Override
    public abstract boolean authorize(User user, Request request);

    @Override
    public boolean processRequest(User user, Request request) {
        if(authenticate(user, request)){
            if(authorize(user, request)){
                return true;
            }else{
                System.out.println("Authorization denied for  Credit Request");
                return false;
            }
        }else{
            throw new RuntimeException("Authentication Failed");
        }
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean hasNextHandler() {
        return nextHandler!=null;
    }

    @Override
    public boolean delegateNextHandler(User user, Request request) {
        if(hasNextHandler()){
            return nextHandler.processRequest(user, request);
        }
        return false;
    }

    protected abstract void printStatus(String message);
}

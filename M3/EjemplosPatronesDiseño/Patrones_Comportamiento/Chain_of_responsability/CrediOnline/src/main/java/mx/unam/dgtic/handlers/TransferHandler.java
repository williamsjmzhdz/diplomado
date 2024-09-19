package mx.unam.dgtic.handlers;

import mx.unam.dgtic.handlers.abstractHandler.AbstractHandler;
import mx.unam.dgtic.model.Request;
import mx.unam.dgtic.model.User;

public class TransferHandler extends AbstractHandler {

    @Override
    public boolean authenticate(User user, Request request) {
        System.out.println("Tu transferencia se ha realizado.");
        return true;
    }

    @Override
    public boolean authorize(User user, Request request) {
        System.out.println("Tu transferencia se ha realizado.");
        return true;
    }

    @Override
    public void printStatus(String message) {
        System.out.println("Transferido.");
    }

}

package mx.unam.dgtic.handlers;

import mx.unam.dgtic.handlers.abstractHandler.AbstractHandler;
import mx.unam.dgtic.model.Request;
import mx.unam.dgtic.model.User;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class RiskAssessmentHandler extends AbstractHandler {
    @Override
    public boolean authenticate(User user, Request request) {
        printStatus("RiskAssessmentHandler: Authenticate...");
        return (user.getScore() < request.getRiskScore());
    }

    @Override
    public boolean authorize(User user, Request request) {
        printStatus("RiskAssessmentHandler: Authorize...");
        if(user.getScore() < request.getRiskScore() && user.getEmail().equals("persona123@gmail.com")){
            System.out.println("Authorization granted for Balance Credit Request");
            System.out.println("Your information is "+user.getCreditLimit()+" and "+user.getScore());
            return delegateNextHandler(user, request);
        }else
            return false;
    }

    @Override
    protected void printStatus(String message) {
        System.out.println("RiskAssessmentHandler:"+message);
    }
}

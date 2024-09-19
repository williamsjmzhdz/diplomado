package mx.unam.dgtic;

import mx.unam.dgtic.handlers.AuthenticationHandler;
import mx.unam.dgtic.handlers.CreditBalanceHandler;
import mx.unam.dgtic.handlers.RiskAssessmentHandler;
import mx.unam.dgtic.handlers.TransferHandler;
import mx.unam.dgtic.handlers.abstractHandler.Handler;
import mx.unam.dgtic.model.Request;
import mx.unam.dgtic.model.User;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Main {
    public static void main(String[] args) {
        Handler authenticationHandler=new AuthenticationHandler();
        Handler creditLimitHandler=new CreditBalanceHandler();
        Handler riskAssessmentHandler=new RiskAssessmentHandler();
        Handler transferHandler=new TransferHandler();

        authenticationHandler.setNextHandler(creditLimitHandler);
        creditLimitHandler.setNextHandler(riskAssessmentHandler);
        riskAssessmentHandler.setNextHandler(transferHandler);

        User userRequest=new User("persona123@gmail.com","admin123","Jhon",10,0.9,1880);
        Request request=new Request(userRequest,50,100);
        authenticationHandler.processRequest(userRequest,request);
    }
}
package mx.unam.dgtic;

import mx.unam.dgtic.factory.MedicalAbstractFactory;
import mx.unam.dgtic.factory.XRayFactory;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class MedicalApplication {
    public static void main(String[] args) {
        MedicalAbstractFactory xRayFactory=new XRayFactory();
        var xRayMachine=xRayFactory.createDevice();
        xRayMachine.performAction();

        var clinicalTest=xRayFactory.createClinicalTest();
        clinicalTest.runTest();

    }
}

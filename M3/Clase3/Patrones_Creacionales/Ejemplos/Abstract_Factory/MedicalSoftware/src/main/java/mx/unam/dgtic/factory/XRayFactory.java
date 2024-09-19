package mx.unam.dgtic.factory;

import mx.unam.dgtic.products.BloodTest;
import mx.unam.dgtic.products.XRayMachine;
import mx.unam.dgtic.products.abstractProducts.ClinicalTest;
import mx.unam.dgtic.products.abstractProducts.Device;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class XRayFactory implements MedicalAbstractFactory {
    @Override
    public Device createDevice() {
        return new XRayMachine();
    }

    @Override
    public ClinicalTest createClinicalTest() {
        return new BloodTest();
    }
}

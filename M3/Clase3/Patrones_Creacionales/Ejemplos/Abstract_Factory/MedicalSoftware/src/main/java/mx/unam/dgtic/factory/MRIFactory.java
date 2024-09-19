package mx.unam.dgtic.factory;

import mx.unam.dgtic.products.MRI;
import mx.unam.dgtic.products.UrineTest;
import mx.unam.dgtic.products.abstractProducts.ClinicalTest;
import mx.unam.dgtic.products.abstractProducts.Device;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class MRIFactory implements MedicalAbstractFactory {
    @Override
    public Device createDevice() {
        return new MRI();
    }

    @Override
    public ClinicalTest createClinicalTest() {
        return new UrineTest();
    }
}

package mx.unam.dgtic.factory;

import mx.unam.dgtic.products.abstractProducts.ClinicalTest;
import mx.unam.dgtic.products.abstractProducts.Device;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public interface MedicalAbstractFactory {
    Device createDevice();
    ClinicalTest createClinicalTest();
}

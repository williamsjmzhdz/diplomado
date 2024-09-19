package mx.unam.dgtic.products;

import mx.unam.dgtic.products.abstractProducts.ClinicalTest;
import mx.unam.dgtic.products.abstractProducts.Device;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class BloodTest implements ClinicalTest {
    @Override
    public void runTest() {
        System.out.println("Blood Test: Running Blood Test");
    }
}

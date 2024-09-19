package mx.unam.dgtic.products;

import mx.unam.dgtic.products.abstractProducts.ClinicalTest;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class UrineTest implements ClinicalTest {
    @Override
    public void runTest() {
        System.out.println("Urine Test: Running Urine Test");
    }
}

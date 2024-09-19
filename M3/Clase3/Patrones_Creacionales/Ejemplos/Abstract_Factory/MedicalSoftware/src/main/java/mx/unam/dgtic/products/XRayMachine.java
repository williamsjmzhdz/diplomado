package mx.unam.dgtic.products;

import mx.unam.dgtic.products.abstractProducts.Device;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class XRayMachine implements Device {
    @Override
    public void performAction() {
        System.out.println("X-ray Machine: Performing XRay scan");
    }
}

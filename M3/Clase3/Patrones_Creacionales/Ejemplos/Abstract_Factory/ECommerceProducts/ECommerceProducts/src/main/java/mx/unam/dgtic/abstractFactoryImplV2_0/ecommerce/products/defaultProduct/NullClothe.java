package mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.defaultProduct;

import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.Cloth;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class NullClothe extends Cloth {
    public NullClothe(String name, String serialNumber, boolean isAvailable, double price) {
        super(name, serialNumber, isAvailable, price);
    }

}

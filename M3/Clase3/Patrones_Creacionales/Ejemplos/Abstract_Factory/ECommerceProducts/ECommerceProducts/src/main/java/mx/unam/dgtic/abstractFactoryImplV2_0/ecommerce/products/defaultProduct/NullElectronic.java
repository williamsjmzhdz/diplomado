package mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.defaultProduct;

import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.Electronic;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.ElectronicType;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class NullElectronic extends Electronic {

    public NullElectronic(String name, String serialNumber, boolean isAvailable, double price) {
        super(ElectronicType.UNDEFINED,name, serialNumber, isAvailable, price);
    }
}

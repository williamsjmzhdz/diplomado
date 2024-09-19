package mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.factory;

import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.ElectronicType;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.Electronic;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.TVElectronic;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.defaultProduct.NullElectronic;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.abstractProduct.Product;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class ElectronicsFactory {

    private String name;
    private String serialNumber;
    private boolean isAvailable;
    private double price;

    public ElectronicsFactory(String name, String serialNumber, boolean isAvailable, double price) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.isAvailable = isAvailable;
        this.price = price;
    }

    public static Product createProduct(ElectronicType type) {
        Electronic product=null;

        switch (type){
            case TV:
                product=new TVElectronic("Samsung OLED","",true,123);
                break;
            default:
                product=new NullElectronic("Desn't existe","NA",false,0.0);
                break;
        }
        return product;
    }
}

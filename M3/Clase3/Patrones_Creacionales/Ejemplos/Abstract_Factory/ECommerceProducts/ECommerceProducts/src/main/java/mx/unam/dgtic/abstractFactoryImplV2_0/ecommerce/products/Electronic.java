package mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products;

import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.abstractProduct.Product;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.ElectronicType;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.ProductType;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Electronic extends Product {

    private ElectronicType type;
    public Electronic(ElectronicType type, String name, String serialNumber, boolean isAvailable, double price) {
        super(ProductType.ELECTRONIC, name, serialNumber, isAvailable, price);
        this.type=type;
    }

    @Override
    protected String getName() {
        return this.name;
    }

    @Override
    protected String getSerialNumber() {
        return this.serialNumber;
    }

    @Override
    protected boolean isAvailable() {
        return this.isAvailable;
    }

    @Override
    protected double getPrice() {
        return this.price;
    }
}

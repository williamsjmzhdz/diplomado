package mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.abstractProduct;

import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.ProductType;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public abstract class Product {
    protected String name;
    protected String serialNumber;
    protected boolean isAvailable;
    protected double price;
    protected ProductType type;

    public Product(ProductType type, String name, String serialNumber, boolean isAvailable, double price) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.isAvailable = isAvailable;
        this.price = price;
        this.type=type;
    }

    public void display(){
        System.out.println("Product[ type="+type+" name ="+name+", serialNumber = "+serialNumber+", isAvailable = "+isAvailable+", price = "+price);
    }
    protected abstract String getName();
    protected abstract String getSerialNumber();
    protected abstract boolean isAvailable();
    protected abstract double getPrice();
}

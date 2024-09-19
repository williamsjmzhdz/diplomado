package mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products;

import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.FoodType;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.ProductType;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.abstractProduct.Product;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Food extends Product {

    private FoodType type;
    public Food(FoodType type, String name, String serialNumber, boolean isAvailable, double price) {
        super(ProductType.FOOD, name, serialNumber, isAvailable, price);
        this.type=type;
    }


    @Override
    public void display() {
        super.display();
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

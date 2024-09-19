package mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products;

import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.FoodType;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class PorkFood extends Food {
    public PorkFood( String name, String serialNumber, boolean isAvailable, double price) {
        super(FoodType.MEAL, name, serialNumber, isAvailable, price);
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

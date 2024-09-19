package mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.factory;

import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.FoodType;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.Food;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.PorkFood;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.defaultProduct.NullFood;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.abstractProduct.Product;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class FoodFactory {

    private String name;
    private String serialNumber;
    private boolean isAvailable;
    private double price;


    public FoodFactory(String name, String serialNumber, boolean isAvailable, double price) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.isAvailable = isAvailable;
        this.price = price;
    }

    public static Product createProduct(FoodType type) {
        Food food=null;

        switch (type){
            case MEAL:
                food= new PorkFood("Pork Belly", "SN123",true,23.2);
            default:
                food=new NullFood("NA","NA",false, 0.0 );
        }
        return food;
    }
}

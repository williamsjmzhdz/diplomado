package mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.defaultProduct;

import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.Food;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.FoodType;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class NullFood extends Food {
    public NullFood(String name, String serialNumber, boolean isAvailable, double price) {
        super(FoodType.UNDEFINED, name, serialNumber, isAvailable, price);
    }

}

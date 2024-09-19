package mx.unam.dgtic.abstractFactoryImplV2_0;

import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.factory.ProductFactory;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.ProductType;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) {
        ProductFactory.getProduct(ProductType.ELECTRONIC).display();
        ProductFactory.getProduct(ProductType.FOOD).display();
        ProductFactory.getProduct(ProductType.BOOK).display();
    }
}
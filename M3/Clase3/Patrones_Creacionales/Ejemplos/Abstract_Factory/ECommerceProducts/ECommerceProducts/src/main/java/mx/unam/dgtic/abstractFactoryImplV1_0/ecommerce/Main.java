package mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce;

import mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.factory.ClothesFactory;
import mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.factory.ElectronicsFactory;
import mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.factory.ProductFactory;
import mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.products.abstractProduct.Product;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Main {
    public static void main(String[] args) {
        Product electronic= ProductFactory.getProduct(new ElectronicsFactory());
        electronic.display();

        Product cloth=ProductFactory.getProduct(new ClothesFactory());
        cloth.display();
    }
}

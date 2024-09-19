package mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.factory.abstractFactory;

import mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.products.abstractProduct.Product;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public interface ProductAbstractFactory {
    Product createProduct();
    void sellProduct();
}

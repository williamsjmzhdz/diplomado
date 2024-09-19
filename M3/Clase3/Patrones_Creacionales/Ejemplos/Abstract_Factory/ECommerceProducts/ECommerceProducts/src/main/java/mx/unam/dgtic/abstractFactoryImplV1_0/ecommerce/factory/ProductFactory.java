package mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.factory;

import mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.factory.abstractFactory.ProductAbstractFactory;
import mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.products.abstractProduct.Product;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class ProductFactory {
    public static Product getProduct(ProductAbstractFactory factory){
        return factory.createProduct();
    }
}

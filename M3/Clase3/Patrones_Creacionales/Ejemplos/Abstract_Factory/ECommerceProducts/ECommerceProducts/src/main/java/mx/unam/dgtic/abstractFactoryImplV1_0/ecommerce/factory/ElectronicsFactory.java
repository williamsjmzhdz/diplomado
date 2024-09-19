package mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.factory;

import mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.factory.abstractFactory.ProductAbstractFactory;
import mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.products.Cloth;
import mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.products.Electronic;
import mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.products.abstractProduct.Product;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class ElectronicsFactory implements ProductAbstractFactory {
    @Override
    public Product createProduct() {
        return new Electronic();
    }

    @Override
    public void sellProduct() {
        System.out.println("Selling...");
    }
}

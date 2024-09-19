package mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.factory;

import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.BookType;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.ElectronicType;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.FoodType;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.ProductType;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.abstractProduct.Product;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class ProductFactory {
    public static Product getProduct(ProductType type){
        Product product=null;
        switch (type){
            case BOOK:
                // This sbould be dinamically by an interface or any input from user
                BookType bookType=BookType.HORROR;
                product=BooksFactory.createProduct(bookType);
                break;
            case FOOD:
                FoodType foodType=FoodType.MEAL;
                product=FoodFactory.createProduct(foodType);
                break;
            case ELECTRONIC:
                ElectronicType electronicType=ElectronicType.TV;
                product=ElectronicsFactory.createProduct(electronicType);
                break;
        }
        return product;
    }
}

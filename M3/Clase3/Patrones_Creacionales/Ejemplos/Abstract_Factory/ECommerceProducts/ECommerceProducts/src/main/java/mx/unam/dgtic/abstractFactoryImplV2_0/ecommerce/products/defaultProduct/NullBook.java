package mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.defaultProduct;

import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.Book;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.BookType;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class NullBook extends Book {
    public NullBook(String name, String serialNumber, boolean isAvailable, double price) {
        super(BookType.UNDEFINED,name, serialNumber, isAvailable, price);
    }

}

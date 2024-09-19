package mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.factory;

import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.BookType;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.Book;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.HorrorBook;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.abstractProduct.Product;

import java.time.LocalDate;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class BooksFactory{

    private String name;
    private String serialNumber;
    private boolean isAvailable;
    private double price;

    private String author;
    private LocalDate date;

    public BooksFactory(String name, String serialNumber, boolean isAvailable, double price) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.isAvailable = isAvailable;
        this.price = price;
    }

    public BooksFactory(String name, String serialNumber, boolean isAvailable, double price, String author, LocalDate date) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.isAvailable = isAvailable;
        this.price = price;
        this.date=date;
        this.author=author;
    }

    public static Product createProduct(BookType type) {

        Book book=null;

        switch (type){
            case HORROR:
                book=new HorrorBook("The Raven","123",true,203.2,"EA POE", LocalDate.now().minusYears(20));
                break;
            case NOVEL:
                book=new HorrorBook("Titanic","123",true,213.2,"", LocalDate.now().minusYears(40));
                break;
            default:
                break;

        }
        return book;
    }
}

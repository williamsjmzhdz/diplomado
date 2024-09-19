package mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products;

import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products.abstractProduct.Product;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.BookType;
import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.ProductType;

import java.time.LocalDate;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Book extends Product {

    private String author;
    private LocalDate release;
    private BookType type;
    public Book(BookType type, String name, String serialNumber, boolean isAvailable, double price) {
        super(ProductType.BOOK, name, serialNumber, isAvailable, price);
        this.type=type;
    }

    public Book(BookType type, String name, String serialNumber, boolean isAvailable, double price, String author, LocalDate release) {
        super(ProductType.BOOK, name, serialNumber, isAvailable, price);
        this.author=author;
        this.release=release;
        this.type=type;

    }

    @Override
    public void display() {
        System.out.println("Book '"+name+", "+author+", released at "+release.toString()+", $"+price);
    }

    @Override
    protected String getName() {
        return this.name;
    }

    @Override
    protected String getSerialNumber() {
        return this.serialNumber;
    }

    @Override
    protected boolean isAvailable() {
        return this.isAvailable;
    }

    @Override
    protected double getPrice() {
        return this.price;
    }
}

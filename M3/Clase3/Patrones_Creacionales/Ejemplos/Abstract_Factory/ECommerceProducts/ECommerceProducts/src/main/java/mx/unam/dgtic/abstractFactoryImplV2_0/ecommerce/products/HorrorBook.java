package mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.products;

import mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.enums.BookType;

import java.time.LocalDate;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class HorrorBook extends Book {

    private String author;
    private LocalDate release;
    public HorrorBook(String name, String serialNumber, boolean isAvailable, double price) {
        super(BookType.HORROR, name, serialNumber, isAvailable, price);
    }

    public HorrorBook(String name, String serialNumber, boolean isAvailable, double price, String author, LocalDate release) {
        super(BookType.HORROR, name, serialNumber, isAvailable, price);
        this.author=author;
        this.release=release;

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

package mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.products;

import mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.products.abstractProduct.Product;

import java.time.LocalDate;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Book implements Product {
    private String name;
    private String author;
    private LocalDate releaseDate;
    private String uuid;

    @Override
    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public void sell() {

    }

    @Override
    public void delete() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate=" + releaseDate +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}

package mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.products;

import mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.products.abstractProduct.Product;

import java.time.LocalDate;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Cloth implements Product {
    private String name;
    private String size;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Cloth{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}

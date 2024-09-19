package mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.products;

import mx.unam.dgtic.abstractFactoryImplV1_0.ecommerce.products.abstractProduct.Product;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Electronic implements Product {

    private String name;
    private String version;
    private String uuid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }

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
}

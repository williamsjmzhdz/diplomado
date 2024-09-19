package mx.unam.dgtic.abstractFactoryImplV2_0.ecommerce.factory;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class ClothesFactory {

    private String name;
    private String serialNumber;
    private boolean isAvailable;
    private double price;

    public ClothesFactory(String name, String serialNumber, boolean isAvailable, double price) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.isAvailable = isAvailable;
        this.price = price;
    }

}

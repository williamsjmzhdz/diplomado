package mx.unam.dgtic.views;

import mx.unam.dgtic.config.SiteConfig;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class ShopView {
    public void viewShop(){
        System.out.println("Shoping day");
        System.out.println("Configuration...");
        var config=SiteConfig.getInstance();
        System.out.println(config.toString());
    }
}

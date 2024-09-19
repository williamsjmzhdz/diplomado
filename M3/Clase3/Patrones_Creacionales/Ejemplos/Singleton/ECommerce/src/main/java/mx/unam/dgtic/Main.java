package mx.unam.dgtic;

import mx.unam.dgtic.config.SiteConfig;
import mx.unam.dgtic.views.ShopView;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Main {
    public static void main(String[] args) {

        String nombre = "Alan";
        String apellido = "";

        var config = SiteConfig.getInstance();

        config.setTheme("DARK");
        config.setSiteName("SHOP CUTE");
        config.setEnableNotifications(true);

        var viewShop=new ShopView();

        viewShop.viewShop();
    }
}
package com.dgtic.dstj15.dip.ecommerce;

import com.dgtic.dstj15.dip.ecommerce.entity.Producto;
import com.dgtic.dstj15.dip.ecommerce.repository.CarritoRepositoryImpl;

public class EcommerceApp {
    public static void main(String[] args) {
        CarritoRepositoryImpl carritoRepository = new CarritoRepositoryImpl();
        CarritoDeCompras carrito = new CarritoDeCompras(carritoRepository);
        carrito.agregarProducto(new Producto("Nescafe", 10.2));

    }
}

package com.dgtic.dstj15.dip.ecommerce.repository;

import com.dgtic.dstj15.dip.ecommerce.entity.Producto;

public class CarritoRepositoryImpl implements CarritoRepository {
    @Override
    public void guardarProducto(Producto producto) {
        // Lógica para guardar el producto en la base de datos
        System.out.println("Guardando producto en la base de datos: " + producto.getNombre());
    }
}
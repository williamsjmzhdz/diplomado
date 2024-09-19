package com.dgtic.dstj15.dip.ecommerce;

import java.util.ArrayList;
import java.util.List;

import com.dgtic.dstj15.dip.ecommerce.entity.Producto;
import com.dgtic.dstj15.dip.ecommerce.repository.CarritoRepositoryImpl;

public class CarritoDeCompras {
    private List<Producto> productos;
    private CarritoRepositoryImpl carritoRepository;

    public CarritoDeCompras(CarritoRepositoryImpl carritoRepository) {
        this.productos = new ArrayList<>();
        this.carritoRepository = carritoRepository;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        carritoRepository.guardarProducto(producto); 
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
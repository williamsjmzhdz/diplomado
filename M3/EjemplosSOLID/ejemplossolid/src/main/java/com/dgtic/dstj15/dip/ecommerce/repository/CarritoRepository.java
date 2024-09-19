package com.dgtic.dstj15.dip.ecommerce.repository;

import com.dgtic.dstj15.dip.ecommerce.entity.Producto;

public interface CarritoRepository {
    public abstract void guardarProducto(Producto producto);
}

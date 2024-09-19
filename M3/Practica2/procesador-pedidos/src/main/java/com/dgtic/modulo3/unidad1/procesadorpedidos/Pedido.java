package com.dgtic.modulo3.unidad1.procesadorpedidos;

import java.util.ArrayList;
import java.util.List;

public class Pedido{
    private Cuenta cuenta;
    private List<Articulo> articulos;
    private double total;
    private Notificacion servicioNotificacion;

    public Pedido(Cuenta cuenta) {
        articulos = new ArrayList<Articulo>();
        this.cuenta = cuenta;
        servicioNotificacion = new Notificacion("PEDIDOSYA.COM", cuenta.obtenerCliente().obtenerCelular());
    }

    public void agregarArticulo(Articulo articulo) {
        articulos.add(articulo);
    }

    public void removerArticulo(Articulo articulo) {
        articulos.remove(articulo);
    }

    public void agregarPago(MetodoPago pago) {
        cuenta.agregarTransaccion(pago);
    }

    public double calcularTotal() {
        return articulos.stream().reduce(0.0, (subtotal, articulo) -> subtotal + articulo.obtenerPrecio(), Double::sum);
    }

    public void realizarPedido() throws Exception {

        if(cuenta.obtenerTransacciones().isEmpty()) {
            throw new Exception("Se necesita un metodo de pago antes de continuar.");
        }

        total = calcularTotal();
        for (Articulo articulo : articulos) {
            articulo.restarStock();
        }
        System.out.println("Total: " + total);
        System.out.println("Pedido realizado...");
        // Enviar notificación
        try {
            servicioNotificacion.enviarNotificacion();
        } catch (Exception e) {
            System.out.println("Error al enviar notificación: " + e.getMessage());
        }
    }

}
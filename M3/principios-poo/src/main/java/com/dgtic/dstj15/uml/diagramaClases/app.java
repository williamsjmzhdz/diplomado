package com.dgtic.dstj15.uml.diagramaClases;

import com.dgtic.dstj15.uml.diagramaClases.clases.Articulo;
import com.dgtic.dstj15.uml.diagramaClases.clases.Cliente;
import com.dgtic.dstj15.uml.diagramaClases.clases.Cuenta;
import com.dgtic.dstj15.uml.diagramaClases.clases.Direccion;
import com.dgtic.dstj15.uml.diagramaClases.clases.MetodoPago;
import com.dgtic.dstj15.uml.diagramaClases.clases.Pedido;
import com.dgtic.dstj15.uml.diagramaClases.clases.Procesador;
import com.dgtic.dstj15.uml.diagramaClases.clases.ProcesadorPedidos;

public class app {
    public static void main(String[] args) {

        Direccion direccionCliente = new Direccion(
            "Calle 123",
            "Las rosas",
            "CDMX",
            "Mexico"
        );
        // Crear cliente
        Cliente cliente = new Cliente(
            "Juan",
            "Perez",
            "123456",
            "9X9X9@example.com",
            "123456789",
            direccionCliente
        );

        // Crear cuenta
        Cuenta cuenta = new Cuenta(cliente);

        // Crear pedido
        Pedido pedido = new Pedido(cuenta);
        
        // Crear Articulos
        Articulo cocaCola = new Articulo(
            "Coca Cola",
            "Bebida",
            100.00
        );

        Articulo cerveza = new Articulo(
            "Cerveza",
            "Bebida",
            200.00
        );

        // Agregar articulos al pedido
        pedido.agregarArticulo(cocaCola);
        pedido.agregarArticulo(cerveza);

        // Realizar pedido
        System.out.println(pedido.calcularTotal());

        // Crear pago
        MetodoPago pago = new MetodoPago(
            100.00,
            "Efectivo"
        );
        pedido.agregarPago(pago);

        // Procesar pedido
        Procesador procesador = new ProcesadorPedidos();
        try {
            procesador.procesar(pedido);
            System.out.println(cuenta.obtenerSaldo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}

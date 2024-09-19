package com.hxadev.unam.producto.ejercicio;

/**
 * @autor Alumno: Jiménez Hernández Francisco Williams
 * @fecha 19/06/2024
 * */
public class Main {
    public static void main(String[] args) {
        // Simula la creación de algunos productos para el eCommerce
        Producto laptop = new Producto("Laptop", 1200.00, "Laptop con procesador Intel i7 y 16GB de RAM");
        Producto smartphone = new Producto("Smartphone", 800.00, "Smartphone con pantalla AMOLED y cámara de 48MP");
        Producto tablet = new Producto("Tablet", 600.00, "Tablet con pantalla de 10 pulgadas y 64GB de almacenamiento");
        Producto smartwatch = new Producto("Smartwatch", 200.00, "Smartwatch con monitor de ritmo cardíaco y GPS");
        Producto auriculares = new Producto("Auriculares", 150.00, "Auriculares inalámbricos con cancelación de ruido");
        Producto monitor = new Producto("Monitor", 300.00, "Monitor 4K de 27 pulgadas");
        Producto tecladoMecanico = new Producto("Teclado Mecánico", 100.00, "Teclado mecánico retroiluminado");
        Producto mouseGamer = new Producto("Mouse Gamer", 50.00, "Mouse gamer con 12 botones programables");
        Producto impresora = new Producto("Impresora", 250.00, "Impresora multifunción con escáner y fotocopiadora");
        Producto discoDuroExterno = new Producto("Disco Duro Externo", 120.00, "Disco duro externo de 2TB");

        System.out.println();

        // Simula la creación, registro e inicio de sesión del cliente 1
        Cliente williams = new Cliente();
        try {
            williams.registrar(
                    "Williams",
                    "williams@gmail.com",
                    "williams123",
                    "Paypal",
                    "williams@gmail.com",
                    "Crédito",
                    1500
            );
        } catch (Exception e) {
            System.err.println("Error al registrar el cliente: " + e.getMessage());
            return;
        }
        williams.login("williams@gmail.com", "williams123");

        System.out.println();

        // Simula la creación, registro e inicio de sesión del cliente 2
        Cliente francisco = new Cliente();
        try {
            francisco.registrar(
                    "Francisco",
                    "francisco@gmail.com",
                    "francisco123",
                    "Tarjeta",
                    "1234567890",
                    "Débito",
                    10000
            );
        } catch (Exception e) {
            System.err.println("Error al registrar el cliente: " + e.getMessage());
            return;
        }
        francisco.login("francisco@gmail.com", "francisco123");

        System.out.println();

        // Agregando y quitando productos al carrito de Williams
        williams.agregarProductoCarrito(laptop);
        williams.agregarProductoCarrito(smartphone);
        williams.agregarProductoCarrito(smartwatch);
        williams.agregarProductoCarrito(auriculares);
        williams.agregarProductoCarrito(discoDuroExterno);
        williams.quitarProductoCarrito(discoDuroExterno);
        williams.quitarProductoCarrito(smartwatch);
        williams.agregarProductoCarrito(impresora);

        System.out.println();

        // Muestra el carrito de Williams luego de agregar productos
        williams.verProductosCarrito();

        System.out.println();

        // Generando el pedido 1 para Williams
        Pedido pedido1 = williams.generarPedido();

        System.out.println();

        // Verificando que el carrito se haya vaciado después de generar el pedido 1
        // y tratando de generar un pedido2 con el carrito vacío: No debe permitirlo.
        williams.verProductosCarrito();
        Pedido pedido2 = williams.generarPedido();

        System.out.println();

        // Agregando productos de nuevo al carrito vacío de Williams
        williams.agregarProductoCarrito(laptop);
        williams.agregarProductoCarrito(smartphone);
        williams.agregarProductoCarrito(laptop);

        System.out.println();

        // Agregando productos al carrito de Francisco
        francisco.agregarProductoCarrito(laptop);
        francisco.agregarProductoCarrito(laptop);
        francisco.agregarProductoCarrito(laptop);

        System.out.println();

        // Mostrando carritos de Williams y Francisco
        francisco.verProductosCarrito();
        williams.verProductosCarrito();

        System.out.println();

        // Generando el pedido 2 para Williams
        pedido2 = williams.generarPedido();

        System.out.println();

        // Verificando que el carrito de Williams se haya vaciado después de generar el pedido 2
        williams.verProductosCarrito();

        System.out.println();

        // Intentando pagar el pedido 1 de Williams: No me dejará porque no hay fondos suficientes
        System.out.println("Intentando pagar el pedido 1...");
        williams.pagarPedido(pedido1);

        System.out.println();

        // Agregamos más saldo al método de pago de Williams para poder pagar
        williams.recargarSaldo(2000);

        System.out.println();

        // Intentando pagar el pedido 1 de nuevo: Esta vez si hay fondos suficientes
        System.out.println("Intentando pagar el pedido 1 de nuevo...");
        williams.pagarPedido(pedido1);

        System.out.println();

        // Mostrando estados de los pedidos de Williams
        System.out.println("El estado del pedido 1 es: " + pedido1.getEstado());
        System.out.println("El estado del pedido 2 es: " + pedido2.getEstado());

        System.out.println();

        // Intentando pagar el pedido 2 de Williams: No me dejará porque no hay fondos suficientes
        System.out.println("Intentando pagar el pedido 2...");
        williams.pagarPedido(pedido2);

        System.out.println();

        // Cancelando el pedido 1 de Williams y devolviendo el dinero
        System.out.println("Cancelando el pedido 1...");
        williams.cancelarPedido(pedido1);

        System.out.println();

        // Mostrando estados de los pedidos de Williams después de la cancelación
        System.out.println("El estado del pedido 1 es: " + pedido1.getEstado());
        System.out.println("El estado del pedido 2 es: " + pedido2.getEstado());

        System.out.println();

        // Francisco intenta pagar y cancelar el pedido 2 del cliente Williams
        // El sistema no debería dejarlo
        System.out.println("Francisco intentando pagar pedido 2 del cliente Williams...");
        francisco.pagarPedido(pedido2);
        System.out.println("Francisco intentando cancelar pedido 2 del cliente Williams...");
        francisco.cancelarPedido(pedido2);

        System.out.println();

        // Generando el pedido 3 para Francisco
        Pedido pedido3 = francisco.generarPedido();

        System.out.println();

        // Verificando que el carrito de Francisco se haya vaciado después de generar el pedido 3
        francisco.verProductosCarrito();

        System.out.println();

        // Intentando pagar el pedido 3 de Francisco
        System.out.println("Intentando pagar el pedido 3...");
        francisco.pagarPedido(pedido3);

        System.out.println();

        // Intentando pagar el pedido 2 de Williams: Esta vez debería dejarnos hacer el pago
        System.out.println("Intentando pagar el pedido 2 de nuevo...");
        williams.pagarPedido(pedido2);

        System.out.println();

        // Mostrando estados de los pedidos
        System.out.println("El estado del pedido 1 es: " + pedido1.getEstado());
        System.out.println("El estado del pedido 2 es: " + pedido2.getEstado());

        System.out.println();

        // Mostrando los detalles de los pedidos
        System.out.println("DETALLES DEL PEDIDO 1");
        System.out.println("\t" + pedido1 + "\n");

        System.out.println("DETALLES DEL PEDIDO 2");
        System.out.println("\t" + pedido2 + "\n");

        System.out.println("DETALLES DEL PEDIDO 3");
        System.out.println("\t" + pedido3 + "\n");
    }
}

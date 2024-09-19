package com.hxadev.unam.producto.ejercicio;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que representa un cliente en el sistema
 * Gestiona el registro, inicio de sesión, generación de pedidos, etc.
 *
 * @autor Alumno: Jiménez Hernández Francisco Williams
 * @fecha 19/06/2024
 */
public class Cliente implements AdministracionPedido {
    private String nombre;
    private String email;
    private String password;
    private MetodoPago metodoPago;
    private Carrito carrito;

    /**
     * Simula el registro de un nuevo cliente con su nombre, correo electrónico, contraseña,
     * método de pago y carrito.
     *
     * @param nombre    El nombre del cliente
     * @param email     El correo electrónico del cliente
     * @param password  La contraseña del cliente
     * @param metodoPago El método de pago del cliente "Paypal" o "Tarjeta"
     * @param identificador Cualquiera; el número de tarjeta o el email de paypal
     * @param tipo El tipo de método de pago: "Crédito", "Débito", etc.
     * @param monto Los fondos de su método de pago
     */
    public void registrar(
            String nombre,
            String email,
            String password,
            String metodoPago,
            String identificador,
            String tipo,
            double monto
    ) {

        if (metodoPago.equals("Paypal")) {
            this.metodoPago = new Paypal(identificador, this, monto, tipo, new Date());
        } else if (metodoPago.equals("Tarjeta")) {
            this.metodoPago = new Tarjeta(identificador, this, monto, tipo, new Date());
        } else {
            throw new IllegalArgumentException("Método de pago inválido: Debe ser \"Paypal\" o \"Tarjeta\".");
        }

        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.carrito = new Carrito(this);
        System.out.println("Usuario '" + this.nombre + "' registrado con éxito.");
    }


    /**
     * Simula un inicio de sesión con el correo electrónico y contraseña proporcionados.
     * Verifica las credenciales y notifica el resultado.
     *
     * @param email     El correo electrónico proporcionado para el inicio de sesión
     * @param password  La contraseña proporcionada para el inicio de sesión
     */
    public boolean login(String email, String password) {
        if (this.email.equals(email) && this.password.equals(password)) {
            System.out.println("Credenciales correctas: sesión de " + nombre + " iniciada con éxito.");
            return true;
        } else {
            System.out.println("Credenciales incorrectas: sesión no iniciada.");
            return false;
        }
    }

    /**
     * Agrega un producto a su carrito
     *
     * @param producto El producto a agregar
     */
    public void agregarProductoCarrito(Producto producto) {
        carrito.agregarProducto(producto);
    }

    /**
     * Quita un producto a su carrito
     *
     * @param producto El producto a quitar
     */
    public void quitarProductoCarrito(Producto producto) {
        carrito.quitarProducto(producto);
    }

    /**
     * Ve los productos de su carrito
     */
    public void verProductosCarrito() {
        System.out.println("Mostrando carrito... \n\t" +
                carrito.toString()
        );
    }

    /**
     * Genera un pedido con base en el carrito del cliente.
     * Vacía el carrito después de generar el pedido.
     *
     * @return El pedido generado
     */
    public Pedido generarPedido() {

        double total = 0;

        if(!carrito.estaVacio()) {

            for(Producto p : carrito.getProductos()) {
                total += p.getPrecio();
            }

            Pedido p = new Pedido(total, carrito.getProductos(), this);
            carrito.vaciarCarrito();

            return p;
        }

        System.out.println("No se puede generar un pedido sin productos.");

        return null;
    }

    /**
     * Recarga saldo al método de pago del cliente
     */
    public void recargarSaldo(double saldo) {
        metodoPago.recargarSaldo(saldo);
    }

    /**
     * Implementa el método cancelarPedido de la interfaz AdministracionPedido.
     * Cancela un pedido y devuelve el costo al método de pago si ya se había pagado previamente.
     *
     * @param pedido El pedido a cancelar
     */
    @Override
    public boolean cancelarPedido(Pedido pedido) {

        if (!this.equals(pedido.getCliente())) {
            System.out.println("El dueño del pedido no corresponde con el cliente que intenta cancelarlo.");
            return false;
        }

        if(pedido.getEstado() == EstadoPedido.PAGADO) {
            recargarSaldo(pedido.getTotal());
            System.out.println("Se devolvió el dinero.");
        }

        pedido.setEstado(EstadoPedido.CANCELADO);

        System.out.println("Pedido número " + pedido.getNumeroPedido() + " CANCELADO.");

        return true;
    }

    /**
     * Implementa el método pagarPedido de la interfaz AdministracionPedido.
     * Paga un pedido y hace el cargo al método de pago solo si el estado del pedido es NO_PAGADO.
     *
     * @param pedido El pedido a pagar
     */
    @Override
    public boolean pagarPedido(Pedido pedido) {

        if (!this.equals(pedido.getCliente())) {
            System.out.println("El dueño del pedido no corresponde con el cliente que intenta pagarlo.");
            return false;
        }

        if(pedido.getEstado() == EstadoPedido.NO_PAGADO) {
            if(metodoPago.realizarPago(pedido.getTotal())) {
                pedido.setEstado(EstadoPedido.PAGADO);
                return true;
            }
        }

        return false;

    }

    /**
     * Retorna una copia del carrito de compras
     *
     * @return La copia del carrito de compras
     */
    public boolean carritoEstaVacio() {
        return carrito.estaVacio();
    }

    /**
     * Retorna el monto en el método del pago del cliente
     *
     * @return Retorna el monto en el método de pago del cliente
     */
    public double getMontoMetodoPago() {
        return metodoPago.getMonto();
    }

    /**
     * Retorna el nombre del cliente
     *
     * @return El nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Representa una instancia de Cliente como cadena
     *
     * @return La representación en cadena de un cliente
     */
    @Override
    public String toString() {
        return nombre;
    }
}

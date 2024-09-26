import com.hxadev.unam.producto.ejercicio.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Cliente.
 */
public class ClienteTest {

    private Cliente clienteWilliams;
    private Cliente clienteFrancisco;
    private Producto laptop;
    private Producto smartphone;
    private Producto tablet;

    @BeforeEach
    public void setUp() {
        laptop = new Producto("Laptop", 1200.00, "Laptop con procesador Intel i7 y 16GB de RAM");
        smartphone = new Producto("Smartphone", 800.00, "Smartphone con pantalla AMOLED y cámara de 48MP");
        tablet = new Producto("Tablet", 600.00, "Tablet con pantalla de 10 pulgadas y 64GB de almacenamiento");

        clienteWilliams = registrarCliente(
                "Williams",
                "williams@gmail.com",
                "williams123",
                "Paypal",
                "williams@gmail.com",
                "Crédito",
                1500
        );        clienteWilliams = registrarCliente(
                "Williams",
                "williams@gmail.com",
                "williams123",
                "Paypal",
                "williams@gmail.com",
                "Crédito",
                1500
        );

        clienteFrancisco = registrarCliente(
                "Francisco",
                "francisco@gmail.com",
                "francisco123",
                "Tarjeta",
                "1234567890",
                "Débito",
                10000
        );
    }

    private Cliente registrarCliente(String nombre, String email, String password, String metodoPago, String detalleMetodoPago, String tipoCuenta, double montoInicial) {
        Cliente cliente = new Cliente();
        try {
            cliente.registrar(nombre, email, password, metodoPago, detalleMetodoPago, tipoCuenta, montoInicial);
        } catch (Exception e) {
            fail("Error al registrar el cliente: " + e.getMessage());
        }
        return cliente;
    }

    @Test
    public void testRegistroClienteMetodoPagoInvalido() {
        String respuestaEsperada = "Método de pago inválido: Debe ser \"Paypal\" o \"Tarjeta\".";
        Exception excepcion = assertThrows(Exception.class, () -> {
            clienteWilliams.registrar(
                    "Williams",
                    "williams@gmail.com",
                    "williams123",
                    "Método de pago inválido",
                    "williams@gmail.com",
                    "Crédito",
                    1500
            );
        });
        assertEquals(respuestaEsperada, excepcion.getMessage());
    }

    @Test
    public void testLoginExitoso() {
        assertTrue(clienteWilliams.login("williams@gmail.com", "williams123"));
    }

    @Test
    public void testLoginFallido() {
        assertFalse(clienteWilliams.login("correoIncorrecto@gmail.com", "contraseñaIncorrecta"));
    }

    @Test
    public void testGeneracionDePedidoExitoso() {
        clienteWilliams.agregarProductoCarrito(laptop);
        clienteWilliams.agregarProductoCarrito(smartphone);
        clienteWilliams.agregarProductoCarrito(tablet);

        double totalEsperado = laptop.getPrecio() + smartphone.getPrecio() + tablet.getPrecio();

        Pedido pedido = clienteWilliams.generarPedido();
        ArrayList<Producto> productosPedido = pedido.getProductos();

        assertNotNull(pedido);
        assertEquals(clienteWilliams, pedido.getCliente());
        assertEquals(totalEsperado, pedido.getTotal());
        assertTrue(clienteWilliams.carritoEstaVacio());
        assertEquals(3, productosPedido.size());
        assertEquals(laptop, productosPedido.get(0));
        assertEquals(smartphone, productosPedido.get(1));
        assertEquals(tablet, productosPedido.get(2));
    }

    @Test
    public void testGeneracionDePedidoFallidoPorCarritoVacio() {
        assertNull(clienteWilliams.generarPedido());
    }

    @Test
    public void testCancelacionDePedidoPagadoExitosa() {
        clienteWilliams.agregarProductoCarrito(laptop);
        Pedido pedido = clienteWilliams.generarPedido();
        double montoAntesDePagar = clienteWilliams.getMontoMetodoPago();
        clienteWilliams.pagarPedido(pedido);
        clienteWilliams.cancelarPedido(pedido);

        assertEquals(EstadoPedido.CANCELADO, pedido.getEstado());
        assertEquals(montoAntesDePagar, clienteWilliams.getMontoMetodoPago());
    }

    @Test
    public void testCancelacionDePedidoNoPagadoOCanceladoExitosa() {
        clienteWilliams.agregarProductoCarrito(laptop);
        Pedido pedido = clienteWilliams.generarPedido();
        double montoAntesDePagar = clienteWilliams.getMontoMetodoPago();

        assertTrue(clienteWilliams.cancelarPedido(pedido));
        assertEquals(EstadoPedido.CANCELADO, pedido.getEstado());
        assertEquals(montoAntesDePagar, clienteWilliams.getMontoMetodoPago());
    }

    @Test
    public void testCancelacionDePedidoFallidaPorClienteAjenoAlPedido() {
        clienteWilliams.agregarProductoCarrito(laptop);
        Pedido pedido = clienteWilliams.generarPedido();

        assertFalse(clienteFrancisco.cancelarPedido(pedido));
    }

    @Test
    public void testPagoDelPedidoExitoso() {
        clienteWilliams.agregarProductoCarrito(laptop);
        double montoEsperadoDespuesDelCobro = clienteWilliams.getMontoMetodoPago() - laptop.getPrecio();
        Pedido pedido = clienteWilliams.generarPedido();

        assertTrue(clienteWilliams.pagarPedido(pedido));
        assertEquals(montoEsperadoDespuesDelCobro, clienteWilliams.getMontoMetodoPago());
    }

    @Test
    public void testPagoDelPedidoFallidoPorClienteAjeno() {
        clienteWilliams.agregarProductoCarrito(laptop);
        double montoClienteWilliamsAntesDePagar = clienteWilliams.getMontoMetodoPago();
        double montoClienteFranciscoAntesDePagar = clienteFrancisco.getMontoMetodoPago();
        Pedido pedido = clienteWilliams.generarPedido();

        assertFalse(clienteFrancisco.pagarPedido(pedido));
        assertEquals(montoClienteWilliamsAntesDePagar, clienteWilliams.getMontoMetodoPago());
        assertEquals(montoClienteFranciscoAntesDePagar, clienteFrancisco.getMontoMetodoPago());
    }

    @Test
    public void testPagoDelPedidoFallidoPorEstadoCancelado() {
        clienteWilliams.agregarProductoCarrito(laptop);
        double montoAntesDePagar = clienteWilliams.getMontoMetodoPago();
        Pedido pedido = clienteWilliams.generarPedido();
        clienteWilliams.cancelarPedido(pedido);

        assertFalse(clienteWilliams.pagarPedido(pedido));
        assertEquals(montoAntesDePagar, clienteWilliams.getMontoMetodoPago());
    }

    @Test
    public void testPagoDelPedidoFallidoPorEstadoPagado() {
        clienteWilliams.agregarProductoCarrito(laptop);
        Pedido pedido = clienteWilliams.generarPedido();
        clienteWilliams.pagarPedido(pedido);
        double montoAntesDePagarPorSegundaVez = clienteWilliams.getMontoMetodoPago();

        assertFalse(clienteWilliams.pagarPedido(pedido));
        assertEquals(montoAntesDePagarPorSegundaVez, clienteWilliams.getMontoMetodoPago());
    }

    @Test
    public void testPagoDelPedidoFallidoPorFondosInsuficientes() {
        clienteWilliams.agregarProductoCarrito(laptop);
        clienteWilliams.agregarProductoCarrito(laptop);
        clienteWilliams.agregarProductoCarrito(laptop);
        clienteWilliams.agregarProductoCarrito(laptop);
        clienteWilliams.agregarProductoCarrito(laptop);

        Pedido pedido = clienteWilliams.generarPedido();
        double montoAntesDePagar = clienteWilliams.getMontoMetodoPago();

        assertFalse(clienteWilliams.pagarPedido(pedido));
        assertEquals(montoAntesDePagar, clienteWilliams.getMontoMetodoPago());
    }

    @Test
    public void testRepresentacionEnCadenaCorrecta() {
        assertEquals(clienteWilliams.getNombre(), clienteWilliams.toString());
        assertEquals(clienteFrancisco.getNombre(), clienteFrancisco.toString());
    }
}

import com.hxadev.unam.producto.ejercicio.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CarritoTest {

    private Carrito carrito;
    private Cliente cliente;
    private Producto laptop;


    @BeforeEach
    public void setUp() {
        cliente = new Cliente();
        carrito = new Carrito(cliente);
        laptop = new Producto("Laptop", 1200.00, "Laptop con procesador Intel i7 y 16GB de RAM");
    }

    @Test
    public void testAgregarProducto() {
        carrito.agregarProducto(laptop);
        ArrayList<Producto> productosCarrito = carrito.getProductos();

        assertEquals(1, productosCarrito.size());
        assertEquals(laptop, productosCarrito.get(0));
    }

    @Test
    public void testQuitarProducto() {
        carrito.agregarProducto(laptop);
        carrito.quitarProducto(laptop);
        ArrayList<Producto> productosCarrito = carrito.getProductos();

        assertEquals(0, productosCarrito.size());
    }

    @Test
    public void testQuitarProductoCarritoVacio() {
        assertFalse(carrito.quitarProducto(laptop));
    }

    @Test
    public void testRepresentacionEnCadenaCorrecta() {
        String representacionEnCadenaEsperada = "Carrito{" +
                "cliente=" + cliente +
                ", productos=" + carrito.getProductos() +
                '}';

        assertEquals(representacionEnCadenaEsperada, carrito.toString());
    }

}

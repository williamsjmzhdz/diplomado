import com.hxadev.unam.producto.ejercicio.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MetodoPagoTest {

    private MetodoPago metodoPago;
    private Cliente cliente;


    @BeforeEach
    public void setUp() {
        cliente = new Cliente();
        metodoPago = new Tarjeta("1234567890", cliente, 1500, "Crédito", new Date());
    }

    @Test
    public void realizarPago() {
        assertTrue(metodoPago.realizarPago(1000));
    }

    @Test
    public void realizarPagoMontoNegativo() {
        assertFalse(metodoPago.realizarPago(-1000));
    }

    @Test
    public void realizarPagoFondosInsuficientes() {
        assertFalse(metodoPago.realizarPago(99999));
    }
}

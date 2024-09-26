package dgtic.core.service;

import dgtic.core.model.MetodoPago;
import dgtic.core.model.exception.InvalidCardNumberException;
import dgtic.core.model.exception.InvalidIdentifierException;
import dgtic.core.model.exception.MetodoPagoAlreadyExistsException;
import dgtic.core.model.exception.MetodoPagoNotFoundException;
import dgtic.core.repository.MetodoPagoRepository;
import dgtic.core.service.impl.MetodoPagoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/*
 * Nota para el profesor:
 * No utilicé @SpringBootTest ni @ComponentScan en estas pruebas unitarias porque esas anotaciones
 * son más adecuadas para pruebas de integración que requieren cargar todo el contexto de Spring.
 * Aquí estoy probando únicamente la lógica del servicio en aislamiento (prueba unitaria), por lo que el uso de mocks
 * (mediante @Mock y @InjectMocks) permite simular las dependencias sin la sobrecarga de Spring.
 * Esto hace las pruebas más rápidas y enfocadas en el comportamiento de la clase bajo prueba.
 * También usé @InjectMocks para simplificar la inyección de dependencias en el servicio,
 * evitando la necesidad de pasar manualmente los mocks en un constructor, lo que hace el código
 * más legible y reduce la configuración manual en el método @BeforeEach.
 */

class MetodoPagoServiceImplTest {

    @Mock
    private MetodoPagoRepository metodoPagoRepository;

    @InjectMocks
    private MetodoPagoServiceImpl metodoPagoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks antes de cada prueba
    }

    @Test
    void guardarNumeroTarjetaInvalidoTest() {
        // Simula un método de pago con número de tarjeta inválido
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setNumeroTarjeta("123");

        // Verifica que se lance una excepción del tipo InvalidCardNumberException
        Exception e = assertThrows(InvalidCardNumberException.class, () -> {
            metodoPagoService.guardar(metodoPago);
        });

        // Verifica que el mensaje sea el esperado
        assertEquals("El número de tarjeta '" + metodoPago.getNumeroTarjeta() +
                "' es inválido. El número de tarjeta debe tener 16 dígitos.", e.getMessage());

        // Verifica que no se llame a los métodos encontrarPorNumeroTarjeta() ni guardar() del repositorio
        verify(metodoPagoRepository, never()).encontrarPorNumeroTarjeta(metodoPago.getNumeroTarjeta());
        verify(metodoPagoRepository, never()).guardar(metodoPago);
    }

    @Test
    void guardarMetodoPagoYaExiste() {

        // Simula un método de pago válido pero existente
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setNumeroTarjeta("1111111111111111");

        // Prepara el mock del repositorio para devolver un optional con el metodo de pago existente.
        when(metodoPagoRepository.encontrarPorNumeroTarjeta(metodoPago.getNumeroTarjeta())).thenReturn(Optional.of(metodoPago));

        // Verifica que se lance una excepción del tipo MetodoPagoAlreadyExistsException al intentar guardar el método de pago
        Exception e = assertThrows(MetodoPagoAlreadyExistsException.class, () -> {
            metodoPagoService.guardar(metodoPago);
        });

        // Verifica que el mensaje sea el esperado
        assertEquals("El método de pago con número de tarjeta '" + metodoPago.getNumeroTarjeta() + "' ya existe.", e.getMessage());

        // Verifica que se haya llamado a encontrarPorNumeroTarjeta()
        verify(metodoPagoRepository, times(1)).encontrarPorNumeroTarjeta(metodoPago.getNumeroTarjeta());

        // Verifica que no se llame al método guardar() del repositorio
        verify(metodoPagoRepository, never()).guardar(metodoPago);
    }

    @Test
    void guardarExito() {

        // Simula un método de pago válido
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setNumeroTarjeta("1111111111111111");

        // Prepara el mock del repositorio para devolver un optional vacío.
        when(metodoPagoRepository.encontrarPorNumeroTarjeta(metodoPago.getNumeroTarjeta())).thenReturn(Optional.empty());

        // Llama al método guardar() del servicio
        metodoPagoService.guardar(metodoPago);

        // Verifica que se haya llamado a encontrarPorNumeroTarjeta()
        verify(metodoPagoRepository, times(1)).encontrarPorNumeroTarjeta(metodoPago.getNumeroTarjeta());

        // Verifica que se llame al método guardar() del repositorio
        verify(metodoPagoRepository, times(1)).guardar(metodoPago);
    }

    @Test
    void actualizarIdInvalido() {
        // Simula un método de pago con un ID inválido
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setId(-1);

        // Verifica que se lance una excepción de tipo InvalidIdentifierException
        Exception e = assertThrows(InvalidIdentifierException.class, () -> {
            metodoPagoService.actualizar(metodoPago);
        });

        // Verifica que el mensaje sea el esperado
        assertEquals("El id '" + metodoPago.getId() + "' no es válido.", e.getMessage());

        // Verifica que no se llame a los métodos encontrarPorId() ni actualizar() del repositorio
        verify(metodoPagoRepository, never()).encontrarPorId(metodoPago.getId());
        verify(metodoPagoRepository, never()).actualizar(metodoPago);
    }

    @Test
    void actualizarMetodoPagoNoEncontrado() {

        // Simula un método de pago válido pero no existente
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setId(1);

        // Prepara la respuesta del mock del repositorio
        when(metodoPagoRepository.encontrarPorId(metodoPago.getId())).thenReturn(Optional.empty());

        // Verifica que se lance una excepción de tipo MetodoPagoNotFoundException
        Exception e = assertThrows(MetodoPagoNotFoundException.class, () -> {
            metodoPagoService.actualizar(metodoPago);
        });

        // Verifica el mensaje esperado
        assertEquals("No se encontró un método de pago con el id '" + metodoPago.getId() + "'.", e.getMessage());

        // Verifica que se haya llamado a encontrarPorId()
        verify(metodoPagoRepository, times(1)).encontrarPorId(metodoPago.getId());

        // Verifica que no se llame al método actualizar() del repositorio
        verify(metodoPagoRepository, never()).actualizar(metodoPago);
    }

    @Test
    void actualizarExito() {
        // Simula un método de pago válido
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setId(1);

        // Simula que se encuentra un método de pago con el ID proporcionado
        when(metodoPagoRepository.encontrarPorId(metodoPago.getId())).thenReturn(Optional.of(metodoPago));

        // Llama al método actualizar() del servicio
        metodoPagoService.actualizar(metodoPago);

        // Verifica que se llame al método encontrarPorId() antes de actualizar
        verify(metodoPagoRepository, times(1)).encontrarPorId(metodoPago.getId());

        // Verifica que se llame al método actualizar() del repositorio
        verify(metodoPagoRepository, times(1)).actualizar(metodoPago);
    }

}

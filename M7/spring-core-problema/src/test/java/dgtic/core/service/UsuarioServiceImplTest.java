package dgtic.core.service;

import dgtic.core.model.Usuario;
import dgtic.core.model.exception.InvalidIdentifierException;
import dgtic.core.model.exception.UsuarioAlreadyExistsException;
import dgtic.core.model.exception.UsuarioNotFoundException;
import dgtic.core.repository.UsuarioRepository;
import dgtic.core.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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

class UsuarioServiceImplTest {

    @Mock // Simula el repositorio de usuarios
    private UsuarioRepository usuarioRepository;

    @InjectMocks // Inyecta el mock en el servicio real
    private UsuarioServiceImpl usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks antes de cada prueba
    }

    @Test
    void guardarUsuarioExistenteTest() {
        // Simula un usuario existente
        Usuario usuarioExistente = new Usuario();
        usuarioExistente.setCorreoElectronico("usuario_existente@test.com");

        // Mock del repositorio: simula que ya existe un usuario con el correo dado
        when(usuarioRepository.encontrarPorCorreoElectronico(usuarioExistente.getCorreoElectronico()))
                .thenReturn(Optional.of(usuarioExistente));

        // Verifica que se lance la excepción de tipo UsuarioAlreadyExistsException
        Exception e = assertThrows(UsuarioAlreadyExistsException.class, () -> {
            usuarioService.guardar(usuarioExistente);
        });

        // Verifica que el mensaje de la excepción sea el esperado
        assertEquals(e.getMessage(),
                "El usuario con correo electrónico '" + usuarioExistente.getCorreoElectronico() + "' ya existe.");

        // Verifica que el método guardar del repositorio no se haya llamado
        verify(usuarioRepository, never()).guardar(any(Usuario.class));
    }

    @Test
    void guardarUsuarioConExitoTest() {
        // Simula un usuario no existente
        Usuario usuarioNoExistente = new Usuario();
        usuarioNoExistente.setCorreoElectronico("usuario_no_existente@test.com");

        // Mock del repositorio: simula que el correo no existe en la base de datos
        when(usuarioRepository.encontrarPorCorreoElectronico(usuarioNoExistente.getCorreoElectronico()))
                .thenReturn(Optional.empty());

        // Llama al método guardar del servicio
        usuarioService.guardar(usuarioNoExistente);

        // Verifica que el método guardar del repositorio sea llamado una vez
        verify(usuarioRepository, times(1)).guardar(usuarioNoExistente);
    }

    @Test
    void encontrarPorIdInvalidoTest() {
        // Simula un ID inválido
        Integer invalidId = -1;

        // Verifica que se lance la excepción InvalidIdentifierException
        Exception e = assertThrows(InvalidIdentifierException.class, () -> {
            usuarioService.encontrarPorId(invalidId);
        });

        // Verifica que el mensaje sea el esperado
        assertEquals(e.getMessage(), "El id '" + invalidId + "' no es válido.");

        // Verifica que no se llame el método encontrarPorId del repositorio
        verify(usuarioRepository, never()).encontrarPorId(invalidId);
    }

    @Test
    void encontrarPorIdUsuarioNoEncontradoTest() {
        // Simula un ID válido
        Integer id = 1;

        // Mock del repositorio: simula que no se encuentra un usuario con el ID dado
        when(usuarioRepository.encontrarPorId(id)).thenReturn(Optional.empty());

        // Verifica que se lance la excepción UsuarioNotFoundException
        Exception e = assertThrows(UsuarioNotFoundException.class, () -> {
            usuarioService.encontrarPorId(id);
        });

        // Verifica que el mensaje sea el esperado
        assertEquals(e.getMessage(), "No se encontró el usuario con id '" + id + "'.");
    }

    @Test
    void encontrarPorIdExitoTest() {
        // Simula un ID válido
        Integer id = 1;

        // Simula el usuario existente con ese ID
        Usuario usuario = new Usuario();
        usuario.setId(id);

        // Mock del repositorio: simula que se encuentra el usuario con el ID dado
        when(usuarioRepository.encontrarPorId(id)).thenReturn(Optional.of(usuario));

        // Llama al método y verifica que el usuario retornado sea el esperado
        Usuario usuarioRetornado = usuarioService.encontrarPorId(id);
        assertEquals(usuario, usuarioRetornado);
    }
}

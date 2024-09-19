package com.dgtic.modulo3.unidad1.procesadorpedidos;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class NotificacionTest {

    Notificacion notificacion;

    @Test
    void cuandoEnviarNotificacionYDestinoNuloEntoncesValidarNullPointerException() {
        // Arrange
        notificacion = new Notificacion("Origen", null);

        // Act y Assert
        assertThrows(NullPointerException.class, () -> {
            notificacion.enviarNotificacion();
        });
    }

    @Test
    void cuandoEnviarNotificacionValidarEstadoDiferente() throws Exception {
        // Arrange
        notificacion = new Notificacion("Origen", "Destino");
        Method metodo = Notificacion.class.getDeclaredMethod("estatusNotificacion");
        metodo.setAccessible(true);

        String estadoInicial = (String) metodo.invoke(notificacion);

        // Act
        notificacion.enviarNotificacion();

        // Assert
        String estadoFinal = (String) metodo.invoke(notificacion);
        assertTrue(estadoInicial != estadoFinal);

    }
}
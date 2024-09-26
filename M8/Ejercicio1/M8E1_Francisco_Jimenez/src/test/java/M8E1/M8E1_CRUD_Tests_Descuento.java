package M8E1;

import M8E1.datos.Descuento;
import M8E1.datos.DescuentoRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Alumno: FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ
 * Asignación: Ejercicio 1
 * Fecha de realización: 24/09/2024
 * Descripción: Pruebas para el CRUD de la entidad Descuento
 */
@SpringBootTest
@Sql({"/schema.sql", "/data.sql"})  // Asegurarse de tener una base limpia en cada ejecución de prueba unitaria - Carga esquema y datos de inicio
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  // Ejecuta las pruebas en orden para un resultado más predecible
public class M8E1_CRUD_Tests_Descuento {

    private final String ALUMNO = "FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ";
    private final int DESCUENTO_ID_INSERTADO = 10;
    private final int DESCUENTO_ID_ELIMINADO = 1;
    private final int DESCUENTO_ID_BUSCAR = 2;
    private final String DESCUENTO_NUEVO_NOMBRE = "Descuento Estudiante";
    private final int PORCENTAJE_ACTUALIZADO = 30;

    @Autowired
    DescuentoRepository descuentoRepositorio;

    @Test
    @Order(1)
    void insertarUnDescuentoTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 1: Insertar un descuento");
        System.out.println("------------------------------");

        // Lista de descuentos antes de la inserción
        System.out.println("Lista de descuentos ANTES de la inserción:");
        descuentoRepositorio.findAll().forEach(System.out::println);

        // Inserción de un nuevo descuento
        Optional<Descuento> existingDescuento = descuentoRepositorio.findById(DESCUENTO_ID_INSERTADO);
        if (existingDescuento.isPresent()) {
            System.out.println("\nEl descuento con ID '" + DESCUENTO_ID_INSERTADO + "' ya existe. No se insertará.");
        } else {
            Descuento nuevoDescuento = new Descuento(DESCUENTO_ID_INSERTADO, 15, DESCUENTO_NUEVO_NOMBRE);
            descuentoRepositorio.save(nuevoDescuento);
            System.out.println("\nNuevo descuento insertado correctamente: " + nuevoDescuento);
        }

        // Lista de descuentos después de la inserción
        System.out.println("\nLista de descuentos DESPUÉS de la inserción:");
        descuentoRepositorio.findAll().forEach(System.out::println);
    }

    @Test
    @Order(2)
    void buscarUnDescuentoPorIdTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 2: Buscar un descuento por ID");
        System.out.println("------------------------------");
        System.out.println("ID del descuento a buscar: " + DESCUENTO_ID_BUSCAR);

        // Búsqueda por ID
        Optional<Descuento> optional = descuentoRepositorio.findById(DESCUENTO_ID_BUSCAR);
        if (optional.isPresent()) {
            System.out.println("Descuento encontrado: " + optional.get());
        } else {
            System.out.println("No se encontró un descuento con id '" + DESCUENTO_ID_BUSCAR + "'.");
        }
    }

    @Test
    @Order(3)
    void buscarTodosLosDescuentosTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 3: Buscar todos los descuentos");
        System.out.println("------------------------------");

        // Lista de todos los descuentos
        Iterable<Descuento> descuentos = descuentoRepositorio.findAll();
        System.out.println("Lista de todos los descuentos:");
        descuentos.forEach(System.out::println);
    }

    @Test
    @Order(4)
    void actualizarUnDescuentoTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 4: Actualizar un descuento");
        System.out.println("------------------------------");

        // Búsqueda de descuento para actualizar
        Optional<Descuento> optional = descuentoRepositorio.findById(DESCUENTO_ID_ELIMINADO);
        if (optional.isPresent()) {
            Descuento descuento = optional.get();
            System.out.println("Descuento ANTES de actualizar: " + descuento);

            // Actualización del descuento
            descuento.setPorcentaje(PORCENTAJE_ACTUALIZADO);
            descuentoRepositorio.save(descuento);
            System.out.println("Descuento DESPUÉS de actualizar: " + descuento);
        } else {
            System.out.println("No se encontró el descuento con ID " + DESCUENTO_ID_ELIMINADO + " para actualizar.");
        }
    }

    @Test
    @Order(5)
    void eliminarUnDescuentoTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 5: Eliminar un descuento");
        System.out.println("------------------------------");

        // Verificación de la categoría antes de eliminar
        Optional<Descuento> optional = descuentoRepositorio.findById(DESCUENTO_ID_ELIMINADO);
        if (optional.isPresent()) {
            Descuento descuentoAEliminar = optional.get();
            System.out.println("Descuento a eliminar: " + descuentoAEliminar);

            // Lista antes de la eliminación
            System.out.println("\nLista de descuentos ANTES de la eliminación:");
            descuentoRepositorio.findAll().forEach(System.out::println);

            // Eliminación
            descuentoRepositorio.delete(descuentoAEliminar);

            // Lista después de la eliminación
            System.out.println("\nLista de descuentos DESPUÉS de la eliminación:");
            descuentoRepositorio.findAll().forEach(System.out::println);
        } else {
            System.out.println("No se encontró el descuento con ID " + DESCUENTO_ID_ELIMINADO + " para eliminar.");
        }
    }

    @Test
    @Order(6)
    void buscarVariosDescuentosTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 6: Buscar varios descuentos por ID");
        System.out.println("------------------------------");

        // Lista de IDs a buscar
        List<Integer> ids = Arrays.asList(1, 2, 3);
        Iterable<Descuento> descuentos = descuentoRepositorio.findAllById(ids);
        System.out.println("Descuentos encontrados:");
        descuentos.forEach(System.out::println);
    }

    @Test
    @Order(7)
    void insertarVariosDescuentosTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 7: Insertar varios descuentos");
        System.out.println("------------------------------");

        // Lista de descuentos a insertar
        List<Descuento> descuentos = Arrays.asList(
                new Descuento(11, 12, "Descuento por Amigo"),
                new Descuento(12, 25, "Descuento Corporativo")
        );

        // Inserción de los descuentos
        descuentoRepositorio.saveAll(descuentos);

        // Verificación
        System.out.println("Descuentos después de la inserción:");
        descuentoRepositorio.findAll().forEach(System.out::println);
    }

    @Test
    @Order(8)
    void eliminarVariosDescuentosTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 8: Eliminar varios descuentos");
        System.out.println("------------------------------");

        // Lista de IDs a eliminar
        List<Integer> ids = Arrays.asList(11, 12);

        // Verificación de los descuentos antes de eliminar
        System.out.println("Descuentos ANTES de la eliminación:");
        descuentoRepositorio.findAll().forEach(System.out::println);

        // Eliminación de los descuentos
        descuentoRepositorio.deleteAllById(ids);

        // Verificación después de eliminar
        System.out.println("\nDescuentos DESPUÉS de la eliminación:");
        descuentoRepositorio.findAll().forEach(System.out::println);
    }
}

package M8E1;

import M8E1.datos.Marca;
import M8E1.datos.MarcaRepository;
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
 * Descripción: Pruebas para el CRUD de la entidad Marca
 */
@SpringBootTest
@Sql({"/schema.sql", "/data.sql"})  // Asegurarse de tener una base limpia en cada ejecución de prueba unitaria - Carga esquema y datos de inicio
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  // Ejecuta las pruebas en orden para un resultado más predecible
public class M8E1_CRUD_Tests_Marca {

    private final String ALUMNO = "FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ";
    private final int MARCA_ID_INSERTADA = 10;
    private final int MARCA_ID_ELIMINADA = 1;
    private final int MARCA_ID_BUSCAR = 2;
    private final String MARCA_NUEVO_NOMBRE = "Puma";

    @Autowired
    MarcaRepository marcaRepositorio;

    @Test
    @Order(1)
    void insertarUnaMarcaTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 1: Insertar una marca");
        System.out.println("------------------------------");

        // Lista de marcas antes de la inserción
        System.out.println("Lista de marcas ANTES de la inserción:");
        marcaRepositorio.findAll().forEach(System.out::println);

        // Inserción de nueva marca
        Optional<Marca> existingMarca = marcaRepositorio.findById(MARCA_ID_INSERTADA);
        if (existingMarca.isPresent()) {
            System.out.println("La marca con ID '" + MARCA_ID_INSERTADA + "' ya existe. No se insertará.");
        } else {
            Marca nuevaMarca = new Marca(MARCA_ID_INSERTADA, MARCA_NUEVO_NOMBRE);
            marcaRepositorio.save(nuevaMarca);
            System.out.println("\nNueva marca insertada correctamente: " + nuevaMarca);
        }

        // Lista de marcas después de la inserción
        System.out.println("\nLista de marcas DESPUÉS de la inserción:");
        marcaRepositorio.findAll().forEach(System.out::println);
    }

    @Test
    @Order(2)
    void buscarUnaMarcaPorIdTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 2: Buscar una marca por ID");
        System.out.println("------------------------------");
        System.out.println("ID de la marca a bucar: " + MARCA_ID_BUSCAR);

        // Búsqueda por ID
        Optional<Marca> optional = marcaRepositorio.findById(MARCA_ID_BUSCAR);
        if (optional.isPresent()) {
            System.out.println("Marca encontrada: " + optional.get());
        } else {
            System.out.println("No se encontró una marca con ID '" + MARCA_ID_BUSCAR + "'.");
        }
    }

    @Test
    @Order(3)
    void buscarTodasLasMarcasTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 3: Buscar todas las marcas");
        System.out.println("------------------------------");

        // Lista de todas las marcas
        Iterable<Marca> marcas = marcaRepositorio.findAll();
        System.out.println("Lista de todas las marcas:");
        marcas.forEach(System.out::println);
    }

    @Test
    @Order(4)
    void actualizarUnaMarcaTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 4: Actualizar una marca");
        System.out.println("------------------------------");

        // Búsqueda de la marca a actualizar
        Optional<Marca> optional = marcaRepositorio.findById(MARCA_ID_ELIMINADA);
        if (optional.isPresent()) {
            Marca marca = optional.get();
            System.out.println("Marca ANTES de actualizar: " + marca);

            // Actualización de la marca
            marca.setNombre(MARCA_NUEVO_NOMBRE);
            marcaRepositorio.save(marca);

            Marca marcaActualizada = marcaRepositorio.findById(MARCA_ID_ELIMINADA).get();
            System.out.println("Marca DESPUÉS de actualizar: " + marcaActualizada);
        } else {
            System.out.println("No se encontró la marca con ID " + MARCA_ID_ELIMINADA + " para actualizar.");
        }
    }

    @Test
    @Order(5)
    void eliminarUnaMarcaTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 5: Eliminar una marca");
        System.out.println("------------------------------");

        // Búsqueda de la marca a eliminar
        Optional<Marca> optional = marcaRepositorio.findById(MARCA_ID_ELIMINADA);
        if (optional.isPresent()) {
            Marca marcaAEliminar = optional.get();
            System.out.println("Marca a eliminar: " + marcaAEliminar);

            // Lista antes de la eliminación
            System.out.println("\nLista de marcas ANTES de la eliminación:");
            marcaRepositorio.findAll().forEach(System.out::println);

            // Eliminación
            marcaRepositorio.delete(marcaAEliminar);

            // Lista después de la eliminación
            System.out.println("\nLista de marcas DESPUÉS de la eliminación:");
            marcaRepositorio.findAll().forEach(System.out::println);
        } else {
            System.out.println("No se encontró la marca con ID " + MARCA_ID_ELIMINADA + " para eliminar.");
        }
    }

    @Test
    @Order(6)
    void buscarVariasMarcasTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 6: Buscar varias marcas por ID");
        System.out.println("------------------------------");

        // Lista de IDs a buscar
        List<Integer> ids = Arrays.asList(1, 2, 3);
        Iterable<Marca> marcas = marcaRepositorio.findAllById(ids);
        System.out.println("Marcas encontradas:");
        marcas.forEach(System.out::println);
    }

    @Test
    @Order(7)
    void insertarVariasMarcasTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 7: Insertar varias marcas");
        System.out.println("------------------------------");

        // Lista de marcas a insertar
        List<Marca> marcas = Arrays.asList(
                new Marca(11, "Under Armour"),
                new Marca(12, "Reebok")
        );

        // Inserción de varias marcas
        marcaRepositorio.saveAll(marcas);

        // Verificación
        System.out.println("Marcas después de la inserción:");
        marcaRepositorio.findAll().forEach(System.out::println);
    }

    @Test
    @Order(8)
    void eliminarVariasMarcasTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 8: Eliminar varias marcas");
        System.out.println("------------------------------");

        // Lista de IDs a eliminar
        List<Integer> ids = Arrays.asList(11, 12);

        // Lista antes de la eliminación
        System.out.println("Marcas ANTES de la eliminación:");
        marcaRepositorio.findAll().forEach(System.out::println);

        // Eliminación de varias marcas
        marcaRepositorio.deleteAllById(ids);

        // Verificación después de eliminar
        System.out.println("\nMarcas DESPUÉS de la eliminación:");
        marcaRepositorio.findAll().forEach(System.out::println);
    }
}

package M8E1;

import M8E1.datos.Categoria;
import M8E1.datos.CategoriaRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Alumno: FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ
 * Asignación: Ejercicio 1
 * Fecha de realización: 24/09/2024
 * Descripción: Pruebas para el CRUD de la entidad Categoría
 */
@SpringBootTest
@Sql({"/schema.sql", "/data.sql"})  // Carga esquema y datos de inicio antes de cada prueba
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Ejecuta las pruebas en orden para un resultado más predecible
public class M8E1_CRUD_Tests_Categoria {

    private final String ALUMNO = "FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ";
    private final int CATEGORIA_ID_INSERTADA = 5;  // ID para la nueva categoría
    private final int CATEGORIA_ID_ELIMINADA = 1;  // ID para la categoría a eliminar
    private final int CATEGORIA_ID_BUSCAR = 3;  // ID para la categoría a buscar
    private final String CATEGORIA_NUEVA_NOMBRE = "Calzado";
    private final String CATEGORIA_ACTUALIZADA_NOMBRE = "Playeras";

    @Autowired
    CategoriaRepository categoriaRepositorio;

    @Test
    @Order(1)
    void insertarUnaCategoriaTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 1: Insertar una categoría");
        System.out.println("------------------------------");

        // Lista de categorías antes de la inserción
        System.out.println("Lista de categorías ANTES de la inserción:");
        categoriaRepositorio.findAll().forEach(System.out::println);

        // Inserción de una nueva categoría
        Optional<Categoria> existingCategory = categoriaRepositorio.findById(CATEGORIA_ID_INSERTADA);
        if (existingCategory.isPresent()) {
            System.out.println("\nLa categoría con ID '" + CATEGORIA_ID_INSERTADA + "' ya existe. No se insertará.");
        } else {
            Categoria nuevaCategoria = new Categoria(CATEGORIA_ID_INSERTADA, CATEGORIA_NUEVA_NOMBRE);
            categoriaRepositorio.save(nuevaCategoria);
            System.out.println("\nNueva categoría insertada correctamente: " + nuevaCategoria);
        }

        // Lista de categorías después de la inserción
        System.out.println("\nLista de categorías DESPUÉS de la inserción:");
        categoriaRepositorio.findAll().forEach(System.out::println);
    }

    @Test
    @Order(2)
    void buscarUnaCategoriaPorIdTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 2: Buscar una categoría por ID");
        System.out.println("------------------------------");
        System.out.println("ID de la categoría a buscar: " + CATEGORIA_ID_BUSCAR);

        // Búsqueda por ID
        Optional<Categoria> optional = categoriaRepositorio.findById(CATEGORIA_ID_BUSCAR);
        if (optional.isPresent()) {
            System.out.println("Categoría encontrada: " + optional.get());
        } else {
            System.out.println("No se encontró una categoría con id '" + CATEGORIA_ID_BUSCAR + "'.");
        }
    }

    @Test
    @Order(3)
    void buscarTodasLasCategoriasTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 3: Buscar todas las categorías");
        System.out.println("------------------------------");

        // Lista de todas las categorías
        Iterable<Categoria> categorias = categoriaRepositorio.findAll();
        System.out.println("Lista de todas las categorías:");
        categorias.forEach(System.out::println);
    }

    @Test
    @Order(4)
    void actualizarUnaCategoriaTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 4: Actualizar una categoría");
        System.out.println("------------------------------");

        // Búsqueda de la categoría para actualizar
        Optional<Categoria> optional = categoriaRepositorio.findById(CATEGORIA_ID_ELIMINADA);
        if (optional.isPresent()) {
            Categoria categoria = optional.get();
            System.out.println("Categoría ANTES de actualizar: " + categoria);

            // Actualización de la categoría
            categoria.setNombre(CATEGORIA_ACTUALIZADA_NOMBRE);
            categoriaRepositorio.save(categoria);
            System.out.println("Categoría DESPUÉS de actualizar: " + categoria);
        } else {
            System.out.println("No se encontró la categoría con ID " + CATEGORIA_ID_ELIMINADA + " para actualizar.");
        }
    }

    @Test
    @Order(5)
    void eliminarUnaCategoriaTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 5: Eliminar una categoría");
        System.out.println("------------------------------");

        // Verificación de la categoría antes de eliminar
        Optional<Categoria> optional = categoriaRepositorio.findById(CATEGORIA_ID_ELIMINADA);
        if (optional.isPresent()) {
            Categoria categoriaAEliminar = optional.get();
            System.out.println("Categoría a eliminar: " + categoriaAEliminar);

            // Lista antes de la eliminación
            System.out.println("\nLista de categorías ANTES de la eliminación:");
            categoriaRepositorio.findAll().forEach(System.out::println);

            // Eliminación
            categoriaRepositorio.delete(categoriaAEliminar);

            // Lista después de la eliminación
            System.out.println("\nLista de categorías DESPUÉS de la eliminación:");
            categoriaRepositorio.findAll().forEach(System.out::println);
        } else {
            System.out.println("No se encontró la categoría con ID " + CATEGORIA_ID_ELIMINADA + " para eliminar.");
        }
    }

    @Test
    @Order(6)
    void buscarVariasCategoriasTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 6: Buscar varias categorías por ID");
        System.out.println("------------------------------");

        // Búsqueda de varias categorías
        List<Integer> ids = List.of(1, 3, 5);  // IDs a buscar
        Iterable<Categoria> categorias = categoriaRepositorio.findAllById(ids);
        System.out.println("Categorías encontradas:");
        categorias.forEach(System.out::println);
    }

    @Test
    @Order(7)
    void insertarVariasCategoriasTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 7: Insertar varias categorías");
        System.out.println("------------------------------");

        // Lista antes de la inserción
        System.out.println("Lista de categorías ANTES de la inserción:");
        categoriaRepositorio.findAll().forEach(System.out::println);

        // Inserción de varias categorías
        List<Categoria> nuevasCategorias = new ArrayList<>();
        nuevasCategorias.add(new Categoria(6, "Sombreros"));
        nuevasCategorias.add(new Categoria(7, "Bufandas"));
        nuevasCategorias.add(new Categoria(8, "Guantes"));

        categoriaRepositorio.saveAll(nuevasCategorias);

        // Lista después de la inserción
        System.out.println("\nLista de categorías DESPUÉS de la inserción:");
        categoriaRepositorio.findAll().forEach(System.out::println);
    }

    @Test
    @Order(8)
    void eliminarVariasCategoriasTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 8: Eliminar varias categorías");
        System.out.println("------------------------------");

        // Lista antes de la eliminación
        System.out.println("Lista de categorías ANTES de la eliminación:");
        categoriaRepositorio.findAll().forEach(System.out::println);

        // Eliminación de varias categorías
        List<Integer> idsEliminar = List.of(6, 7, 8);  // IDs de las categorías a eliminar
        Iterable<Categoria> categoriasAEliminar = categoriaRepositorio.findAllById(idsEliminar);
        categoriaRepositorio.deleteAll(categoriasAEliminar);

        // Lista después de la eliminación
        System.out.println("\nLista de categorías DESPUÉS de la eliminación:");
        categoriaRepositorio.findAll().forEach(System.out::println);
    }
}

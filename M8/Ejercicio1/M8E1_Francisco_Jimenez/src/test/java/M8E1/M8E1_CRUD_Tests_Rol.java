package M8E1;

import M8E1.datos.Rol;
import M8E1.datos.RolRepository;
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
 * Descripción: Pruebas para el CRUD de la entidad Rol
 */
@SpringBootTest
@Sql({"/schema.sql", "/data.sql"})  // Asegurarse de tener una base limpia en cada ejecución de prueba unitaria - Carga esquema y datos de inicio
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  // Ejecuta las pruebas en orden para un resultado más predecible
public class M8E1_CRUD_Tests_Rol {

    private final String ALUMNO = "FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ";
    private final int ROL_ID_INSERTADO = 10;  // ID para el nuevo rol
    private final int ROL_ID_ELIMINADO = 1;  // ID para el rol a eliminar
    private final int ROL_ID_BUSCAR = 2;  // ID para el rol a buscar
    private final String ROL_NUEVO_NOMBRE = "Gestor";
    private final String ROL_NUEVA_DESCRIPCION = "Gestiona tareas administrativas";

    @Autowired
    RolRepository rolRepositorio;

    @Test
    @Order(1)
    void insertarUnRolTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 1: Insertar un rol");
        System.out.println("------------------------------");

        // Lista de roles antes de la inserción
        System.out.println("Lista de roles ANTES de la inserción:");
        rolRepositorio.findAll().forEach(System.out::println);

        Optional<Rol> existingRol = rolRepositorio.findById(ROL_ID_INSERTADO);
        if (existingRol.isPresent()) {
            System.out.println("El rol con ID '" + ROL_ID_INSERTADO + "' ya existe. No se insertará.");
        } else {
            Rol nuevoRol = new Rol(ROL_ID_INSERTADO, ROL_NUEVO_NOMBRE, ROL_NUEVA_DESCRIPCION);
            rolRepositorio.save(nuevoRol);
            System.out.println("\nRol nuevo insertado correctamente: " + nuevoRol);
        }

        // Lista de roles después de la inserción
        System.out.println("\nLista de roles DESPUÉS de la inserción:");
        rolRepositorio.findAll().forEach(System.out::println);
    }

    @Test
    @Order(2)
    void buscarUnRolPorIdTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 2: Buscar un rol por ID");
        System.out.println("------------------------------");
        System.out.println("ID del rol a buscar: " + ROL_ID_BUSCAR);

        Optional<Rol> optional = rolRepositorio.findById(ROL_ID_BUSCAR);
        if (optional.isPresent()) {
            System.out.println("Rol encontrado: " + optional.get());
        } else {
            System.out.println("No se encontró un rol con ID '" + ROL_ID_BUSCAR + "'.");
        }
    }

    @Test
    @Order(3)
    void buscarTodosLosRolesTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 3: Buscar todos los roles");
        System.out.println("------------------------------");

        Iterable<Rol> roles = rolRepositorio.findAll();
        System.out.println("Lista de todos los roles:");
        roles.forEach(System.out::println);
    }

    @Test
    @Order(4)
    void actualizarUnRolTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 4: Actualizar un rol");
        System.out.println("------------------------------");

        Optional<Rol> optional = rolRepositorio.findById(ROL_ID_ELIMINADO);
        if (optional.isPresent()) {
            Rol rol = optional.get();
            System.out.println("Rol ANTES de actualizar: " + rol);

            rol.setNombre(ROL_NUEVO_NOMBRE);
            rol.setDescripcion(ROL_NUEVA_DESCRIPCION);
            rolRepositorio.save(rol);

            Rol rolActualizado = rolRepositorio.findById(ROL_ID_ELIMINADO).get();
            System.out.println("Rol DESPUÉS de actualizar: " + rolActualizado);
        } else {
            System.out.println("No se encontró el rol con ID " + ROL_ID_ELIMINADO + " para actualizar.");
        }
    }

    @Test
    @Order(5)
    void eliminarUnRolTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 5: Eliminar un rol");
        System.out.println("------------------------------");

        Optional<Rol> optional = rolRepositorio.findById(ROL_ID_ELIMINADO);
        if (optional.isPresent()) {
            Rol rolAEliminar = optional.get();
            System.out.println("Rol a eliminar: " + rolAEliminar);

            // Lista antes de la eliminación
            System.out.println("\nLista de roles ANTES de la eliminación:");
            rolRepositorio.findAll().forEach(System.out::println);

            // Eliminación
            rolRepositorio.delete(rolAEliminar);

            // Lista después de la eliminación
            System.out.println("\nLista de roles DESPUÉS de la eliminación:");
            rolRepositorio.findAll().forEach(System.out::println);
        } else {
            System.out.println("No se encontró el rol con ID " + ROL_ID_ELIMINADO + " para eliminar.");
        }
    }

    @Test
    @Order(6)
    void buscarVariosRolesTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 6: Buscar varios roles por ID");
        System.out.println("------------------------------");

        // Lista de IDs a buscar
        List<Integer> ids = Arrays.asList(1, 2, 3);
        Iterable<Rol> roles = rolRepositorio.findAllById(ids);
        System.out.println("Roles encontrados:");
        roles.forEach(System.out::println);
    }

    @Test
    @Order(7)
    void insertarVariosRolesTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 7: Insertar varios roles");
        System.out.println("------------------------------");

        // Lista de roles a insertar
        List<Rol> roles = Arrays.asList(
                new Rol(11, "Supervisor", "Supervisa actividades de las operaciones"),
                new Rol(12, "Operador", "Gestiona las operaciones diarias")
        );

        // Inserción de varios roles
        rolRepositorio.saveAll(roles);

        // Verificación
        System.out.println("Roles después de la inserción:");
        rolRepositorio.findAll().forEach(System.out::println);
    }

    @Test
    @Order(8)
    void eliminarVariosRolesTest() {
        System.out.println("\n==============================");
        System.out.println(ALUMNO);
        System.out.println("Prueba 8: Eliminar varios roles");
        System.out.println("------------------------------");

        // Lista de IDs a eliminar
        List<Integer> ids = Arrays.asList(11, 12);

        // Lista antes de la eliminación
        System.out.println("Roles ANTES de la eliminación:");
        rolRepositorio.findAll().forEach(System.out::println);

        // Eliminación de varios roles
        rolRepositorio.deleteAllById(ids);

        // Verificación después de eliminar
        System.out.println("\nRoles DESPUÉS de la eliminación:");
        rolRepositorio.findAll().forEach(System.out::println);
    }
}

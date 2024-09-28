package mx.unam.dgtic;

import mx.unam.dgtic.datos.Materia;
import mx.unam.dgtic.datos.MateriaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * Autor: Jiménez Hernández Francisco Williams
 * Fecha de realización: 28 de septiembre de 2024
 */
@SpringBootTest
public class M804_03MateriasTests {

    final String ALUMNO = "FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ";
    private static final int PAGE_SIZE = 5;

    @Autowired
    MateriaRepository repositorioMateria;

    @Test
    public void testBuscarConsultasDerivadas() {
        System.out.println("=== Pruebas de consultas derivadas ===");
        System.out.println("Pruebas realizadas por: " + ALUMNO);
        System.out.println("-------------------------------------");

        // Prueba de búsqueda por nombre de materia
        System.out.println("Consulta derivada: findByMateria('Matemáticas Básicas')");
        repositorioMateria.findByMateria("Matemáticas Básicas").forEach(materia ->
                System.out.println("Resultado: " + materia));
        System.out.println(); // Espacio para legibilidad

        // Prueba de búsqueda por créditos
        System.out.println("Consulta derivada: findByCreditos(4)");
        repositorioMateria.findByCreditos(4).forEach(materia ->
                System.out.println("Resultado: " + materia));
        System.out.println(); // Espacio para legibilidad

        // Prueba de búsqueda por horas mayores que
        System.out.println("Consulta derivada: findByHorasGreaterThan(50)");
        repositorioMateria.findByHorasGreaterThan(50).forEach(materia ->
                System.out.println("Resultado: " + materia));
        System.out.println(); // Espacio para legibilidad

        // Prueba de búsqueda por créditos menores o iguales que
        System.out.println("Consulta derivada: findByCreditosLessThanEqual(5)");
        repositorioMateria.findByCreditosLessThanEqual(5).forEach(materia ->
                System.out.println("Resultado: " + materia));
        System.out.println(); // Espacio para legibilidad

        // Prueba de búsqueda por nombre de materia que contenga una cadena parcial
        System.out.println("Consulta derivada: findByMateriaContaining('Química')");
        repositorioMateria.findByMateriaContaining("Química").forEach(materia ->
                System.out.println("Resultado: " + materia));

        System.out.println("=== Fin de las pruebas de consultas derivadas ===\n");
    }

    @Test
    public void testBuscarConsultasJPQL() {
        System.out.println("=== Pruebas de consultas JPQL ===");
        System.out.println("Pruebas realizadas por: " + ALUMNO);
        System.out.println("---------------------------------");

        // Prueba de búsqueda por créditos mayores o iguales a 5
        System.out.println("Consulta JPQL: buscarPorCreditosMayores(5)");
        repositorioMateria.buscarPorCreditosMayores(5).forEach(materia ->
                System.out.println("Resultado: " + materia));
        System.out.println(); // Espacio para legibilidad

        // Prueba de búsqueda por horas igual a 50
        System.out.println("Consulta JPQL: buscarPorHoras(50)");
        repositorioMateria.buscarPorHoras(50).forEach(materia ->
                System.out.println("Resultado: " + materia));
        System.out.println(); // Espacio para legibilidad

        // Prueba de búsqueda de materias cuyo nombre contenga 'Prog'
        System.out.println("Consulta JPQL: buscarPorMateriaContiene('Prog')");
        repositorioMateria.buscarPorMateriaContiene("Prog").forEach(materia ->
                System.out.println("Resultado: " + materia));

        System.out.println("=== Fin de las pruebas de consultas JPQL ===\n");
    }

    @Test
    public void testBuscarConsultasSQL() {
        System.out.println("=== Pruebas de consultas SQL nativas ===");
        System.out.println("Pruebas realizadas por: " + ALUMNO);
        System.out.println("---------------------------------------");

        // Prueba de búsqueda de materias con más horas que el promedio
        System.out.println("Consulta SQL nativa: buscarMateriasConMasHorasPromedio()");
        repositorioMateria.buscarMateriasConMasHorasPromedio().forEach(materia ->
                System.out.println("Resultado: " + materia));
        System.out.println(); // Espacio para legibilidad

        // Prueba de contar materias con 4 créditos
        System.out.println("Consulta SQL nativa: contarMateriasPorCreditos(4)");
        long count = repositorioMateria.contarMateriasPorCreditos(4);
        System.out.println("Resultado: Número de materias con 4 créditos: " + count);

        System.out.println("=== Fin de las pruebas de consultas SQL nativas ===\n");
    }

    @Test
    public void testBuscarConsultasPaginadas() {
        System.out.println("=== Pruebas de paginación ===");
        System.out.println("Pruebas realizadas por: " + ALUMNO);
        System.out.println("----------------------------");

        Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by("materia").ascending());
        Page<Materia> materiaPage = repositorioMateria.findAll(pagina);

        // Mostrar detalles de la primera página
        System.out.println("=== Página 1 de " + materiaPage.getTotalPages() + " ===");
        materiaPage.forEach(materia -> System.out.println("Resultado: " + materia));
        System.out.println("\n<<< Información de la Página 1 >>>");
        mostrarInformacionDePagina(materiaPage);

        System.out.println(); // Espacio entre páginas para mayor claridad

        // Obtener la segunda página
        pagina = PageRequest.of(1, PAGE_SIZE, Sort.by("materia").ascending());
        materiaPage = repositorioMateria.findAll(pagina);

        System.out.println("=== Página 2 de " + materiaPage.getTotalPages() + " ===");
        materiaPage.forEach(materia -> System.out.println("Resultado: " + materia));
        System.out.println("\n<<< Información de la Página 2 >>>");
        mostrarInformacionDePagina(materiaPage);
    }

    public void mostrarInformacionDePagina(Page<Materia> materiaPage) {
        System.out.println("Número total de materias: " + materiaPage.getTotalElements());
        System.out.println("Número total de páginas: " + materiaPage.getTotalPages());
        System.out.println("Página actual: " + (materiaPage.getNumber() + 1));  // Añadimos +1 para mostrar el número humano (empezar en 1)
        System.out.println("Materias en la página actual: " + materiaPage.getNumberOfElements());
        System.out.println("Tamaño de la página: " + materiaPage.getSize());
        System.out.println("¿Es la primera página? " + materiaPage.isFirst());
        System.out.println("¿Es la última página? " + materiaPage.isLast());
        System.out.println("¿Hay una página siguiente? " + materiaPage.hasNext());
        System.out.println("¿Hay una página anterior? " + materiaPage.hasPrevious());
    }

    @Test
    public void testBuscarMateriasOrdenadas() {
        System.out.println("=== Pruebas de salidas ordenadas ===");
        System.out.println("Pruebas realizadas por: " + ALUMNO);
        System.out.println("------------------------------------");

        // Ordenar por nombre de la materia en orden ascendente
        System.out.println("Materias ordenadas por nombre (ascendente):");
        Sort sortByNombreAsc = Sort.by(Sort.Direction.ASC, "materia");
        repositorioMateria.findAll(sortByNombreAsc).forEach(materia ->
                System.out.println("Resultado: " + materia));
        System.out.println(); // Espacio para legibilidad

        // Ordenar por créditos en orden descendente
        System.out.println("Materias ordenadas por créditos (descendente):");
        Sort sortByCreditosDesc = Sort.by(Sort.Direction.DESC, "creditos");
        repositorioMateria.findAll(sortByCreditosDesc).forEach(materia ->
                System.out.println("Resultado: " + materia));
        System.out.println(); // Espacio para legibilidad

        // Ordenar por horas en orden ascendente
        System.out.println("Materias ordenadas por horas (ascendente):");
        Sort sortByHorasAsc = Sort.by(Sort.Direction.ASC, "horas");
        repositorioMateria.findAll(sortByHorasAsc).forEach(materia ->
                System.out.println("Resultado: " + materia));

        System.out.println("=== Fin de las pruebas de salidas ordenadas ===");
    }


}

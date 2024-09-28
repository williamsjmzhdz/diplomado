package mx.unam.dgtic;

import mx.unam.dgtic.datos.Alumno;
import mx.unam.dgtic.datos.AlumnoPagingAndSortingRepository;
import mx.unam.dgtic.datos.ConteoPorCampo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class M804_02PagingAndSortingTests {

    final String ALUMNO = "FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ";
    private static final int PAGE_SIZE = 10;

    @Autowired
    AlumnoPagingAndSortingRepository repositorioAlumno;

    @Test
    void buscarTodosPaginaTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar Todos los Alumnos Paginados:");

        Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by("nombre").ascending());
        Page<Alumno> alumnoPage = repositorioAlumno.findAll(pagina);

        System.out.println("Página 1 de " + alumnoPage.getTotalPages());
        alumnoPage.forEach(System.out::println);

        pagina = PageRequest.of(3, PAGE_SIZE, Sort.by("nombre").ascending());
        alumnoPage = repositorioAlumno.findAll(pagina);

        System.out.println("Página 2 de " + alumnoPage.getTotalPages());
        alumnoPage.forEach(System.out::println);

        mostrarInformacionDePagina(alumnoPage);
    }

    @Test
    void buscarTodosPaginaWhileTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar Todos los Alumnos Paginados");

        Pageable pagina = PageRequest.of(0, PAGE_SIZE,
                Sort.by("nombre").ascending());

        Page<Alumno> alumnoPage;
        do {
            alumnoPage = repositorioAlumno.findAll(pagina);
            System.out.println("Página " + (pagina.getPageNumber() + 1) + " de " + alumnoPage.getTotalPages());
            alumnoPage.forEach(System.out::println);
            pagina = alumnoPage.nextPageable();
            //pagina = alumnoPage.previousPageable();
            //pagina = alumnoPage.previousOrFirstPageable();
        } while (alumnoPage.hasNext());
    }

    @ParameterizedTest
    @ValueSource(strings = {"nombre", "paterno", "estatura", "fnac"})
    void buscarAlumnosOrdenadosTest(String campo) {
        System.out.println(ALUMNO);
        System.out.println("Ordenado por " + campo);
        Sort sort = Sort.by(Sort.Direction.DESC, campo);
        repositorioAlumno.findAll(sort).forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"nombre", "paterno", "estatura", "fnac"})
    void buscarTodosPaginaWhileTest(String campo) {
        System.out.println(ALUMNO);
        System.out.println("Buscar Todos los Alumnos Paginados");
        System.out.println("Ordenado por: " + campo);  // Añadido para saber por qué campo está ordenado

        Pageable pagina = PageRequest.of(0, PAGE_SIZE,
                Sort.by(campo).ascending());

        Page<Alumno> alumnoPage;
        do {
            alumnoPage = repositorioAlumno.findAll(pagina);
            System.out.println("Pagina " + (pagina.getPageNumber() + 1)
                    + " de " + alumnoPage.getTotalPages());
            alumnoPage.forEach(System.out::println);
            pagina = alumnoPage.nextPageable();
        } while (alumnoPage.hasNext());
    }

    @Test
    void buscarCurpLikeWhileTest() {
        String patron = "%QT%";
        System.out.println(ALUMNO);
        System.out.println("Buscar Por Curp Like " + patron);

        Pageable pagina = PageRequest.of(0, PAGE_SIZE,
                Sort.by("nombre").ascending());

        Page<Alumno> alumnoPage;
        do {
            alumnoPage = repositorioAlumno.findByCurpLike(patron, pagina);
            System.out.println("Página " + (pagina.getPageNumber() + 1)
                    + " de " + alumnoPage.getTotalPages()
                    + " con " + alumnoPage.getNumberOfElements() + " Elementos "
                    + "de [" + alumnoPage.getTotalElements() + "] Alumnos");
            alumnoPage.forEach(System.out::println);
            pagina = alumnoPage.nextPageable();
        } while (alumnoPage.hasNext());

    }

    @Test
    void contarPorNombreWhileTest(){
        System.out.println(ALUMNO);
        System.out.println("Contar por nombre");

        Pageable pagina = PageRequest.of(0, PAGE_SIZE,
                Sort.by("conteo").descending());

        Page<ConteoPorCampo> alumnoPage;
        do{
            alumnoPage = repositorioAlumno.contarPorNombre(pagina);
            System.out.println("Pagina " + (pagina.getPageNumber() + 1)
                    + " de " + alumnoPage.getTotalPages()
                    + " con " + alumnoPage.getNumberOfElements() + " Elementos"
                    + " de [" + alumnoPage.getTotalElements() + "] Nombres");

            alumnoPage.forEach(cp ->
                    System.out.println(cp.getCampo() + " " + cp.getConteo())
            );
            pagina = alumnoPage.nextPageable();
        } while (alumnoPage.hasNext());
    }

    @Test
    void contarPorSexoWhileTest() {
        System.out.println(ALUMNO);
        System.out.println("Contar por sexo");

        Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by("campo").ascending());
        Page<ConteoPorCampo> alumnoPage;

        do {
            alumnoPage = repositorioAlumno.contarPorSexo(pagina);

            System.out.println("Página " + (pagina.getPageNumber() + 1) + " de " + alumnoPage.getTotalPages()
                    + " con " + alumnoPage.getNumberOfElements() + " Elementos"
                    + " de [" + alumnoPage.getTotalElements() + "] Sexo");

            alumnoPage.forEach(alumno -> {
                System.out.println(alumno.getCampo() + " " + alumno.getConteo());
            });

            pagina = alumnoPage.nextPageable();
        } while (alumnoPage.hasNext());
    }

    public void mostrarInformacionDePagina(Page<Alumno> alumnoPage) {
        System.out.println("<<< Informacion De Pagina >>>");
        // Número total de elementos en todas las páginas
        System.out.println("Número total de alumnos: " + alumnoPage.getTotalElements());

        // Número total de páginas
        System.out.println("Número total de páginas: " + alumnoPage.getTotalPages());

        // Número de la página actual (comienza en 0)
        System.out.println("Página actual: " + alumnoPage.getNumber());

        // Número de elementos en la página actual
        System.out.println("Número de alumnos en la página actual: " + alumnoPage.getNumberOfElements());

        // Tamaño de la página (cuántos elementos se muestran por página)
        System.out.println("Tamaño de la página (número máximo de alumnos por página): " + alumnoPage.getSize());

        // ¿Es esta la primera página?
        System.out.println("¿Es la primera página? " + alumnoPage.isFirst());

        // ¿Es esta la última página?
        System.out.println("¿Es la última página? " + alumnoPage.isLast());

        // ¿Hay una página siguiente disponible?
        System.out.println("¿Hay una página siguiente? " + alumnoPage.hasNext());

        // ¿Hay una página anterior disponible?
        System.out.println("¿Hay una página anterior? " + alumnoPage.hasPrevious());

        // Obtener la lista de alumnos en la página actual
        System.out.println("Alumnos en la página actual:");
        alumnoPage.getContent().forEach(System.out::println);
    }

}

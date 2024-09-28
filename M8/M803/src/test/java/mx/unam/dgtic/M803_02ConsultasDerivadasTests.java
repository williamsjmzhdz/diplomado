package mx.unam.dgtic;

import mx.unam.dgtic.datos.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Arrays;

@SpringBootTest
public class M803_02ConsultasDerivadasTests {

    final String ALUMNO = "FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ";
    private static final String NOMBRE = "Carlos David";
    private static final String PATERNO = "Perez";
    private static final double ESTATURA = 1.63;
    private static final Date FECHA = Date.valueOf("1991-04-03");
    private static final String CURP = "ROCD910124HDFTLR04";
    private static final String PATRON = "a";

    @Autowired
    private AlumnoRepository repositorioAlumno;

    @Test
    void buscarInBetweenTest(){
        System.out.println(ALUMNO);

        System.out.println("Alumno IN estatura " + ESTATURA + ", 1.68, 1.56");
        repositorioAlumno.searchByEstaturaIn(Arrays.asList(ESTATURA, 1.68, 1.56))
                .forEach(System.out::println);

        System.out.println("Alumno NOT IN estatura " + ESTATURA + ", 1.68, 1.56");
        repositorioAlumno.searchByEstaturaNotIn(Arrays.asList(ESTATURA, 1.68, 1.56))
                .forEach(System.out::println);

        System.out.println("Alumno IN " + NOMBRE + ", Carlos, Javier");
        repositorioAlumno.searchByNombreIn(Arrays.asList(NOMBRE, "Carlos", "Javier"))
                .forEach(System.out::println);


        System.out.println("Alumno Between " + NOMBRE + ", Javier");
        repositorioAlumno.searchByNombreBetweenOrderByNombre(NOMBRE, "Javier")
                .forEach(System.out::println);

    }

    @Test
    void buscarPorFechaYEstaturaTest() {

        System.out.println(ALUMNO);

        // Consultas basadas en la fecha de nacimiento
        System.out.println("Buscar alumnos nacidos antes de " + FECHA);
        repositorioAlumno.queryByFnacBefore(FECHA).forEach(System.out::println);

        System.out.println("Buscar alumnos nacidos después de " + FECHA);
        repositorioAlumno.queryByFnacAfter(FECHA).forEach(System.out::println);

        // Consultas basadas en la estatura
        System.out.println("Buscar alumnos con estatura menor que " + ESTATURA);
        repositorioAlumno.queryByEstaturaLessThan(ESTATURA).forEach(System.out::println);

        System.out.println("Buscar alumnos con estatura menor o igual a " + ESTATURA);
        repositorioAlumno.queryByEstaturaLessThanEqual(ESTATURA).forEach(System.out::println);

        System.out.println("Buscar alumnos con estatura mayor que " + ESTATURA);
        repositorioAlumno.queryByEstaturaGreaterThan(ESTATURA).forEach(System.out::println);

        System.out.println("Buscar alumnos con estatura mayor o igual a " + ESTATURA);
        repositorioAlumno.queryByEstaturaGreaterThanEqual(ESTATURA).forEach(System.out::println);


    }

    @Test
    void buscarPatronTest(){
        System.out.println(ALUMNO);

        System.out.println("Alumno nombre inicia con " + PATRON);
        repositorioAlumno.findByNombreStartingWith(PATRON).forEach(System.out::println);

        System.out.println("Alumno nombre contiene con " + PATRON);
        repositorioAlumno.findByNombreContaining(PATRON).forEach(System.out::println);

        System.out.println("Alumno nombre termina con " + PATRON);
        repositorioAlumno.findByNombreEndingWith(PATRON).forEach(System.out::println);

    }

    @ParameterizedTest
    @CsvSource({
            "'a%' , 'Inicia con a'",
            "'%a%' , 'Contiene a'",
            "'%a' , 'Termina con a'",
            "'___', 'Tres caracteres'",
            "'___a%', 'a en la 4ta pos'",
            "'___a% %', 'a en la 4ta pos y 2 nombres'",
            "'%a__', 'a en la antepenultima pos'",
            "'% %', 'Dos nombres'",
            "'% %a', 'Dos nombres y el segundo termina en a'"
    })
    void buscarLikeTest(String patron, String descripcion) {
        System.out.println(ALUMNO);
        System.out.println(repositorioAlumno.countByNombreLike(patron) +
                " Nombre " + descripcion + " " + patron);
        repositorioAlumno.findByNombreLike(patron).forEach(System.out::println);

        System.out.println(repositorioAlumno.countByNombreNotLike(patron) +
                " Nombre NO " + descripcion + " " + patron);
        repositorioAlumno.findByNombreNotLike(patron).forEach(System.out::println);
    }

    @Test
    void eliminarLikeTest() {
        System.out.println(ALUMNO);
        System.out.println(repositorioAlumno.count() + " Alumnos antes de eliminar");
        repositorioAlumno.deleteByNombreLike("% %").forEach(System.out::println);
        System.out.println(repositorioAlumno.count() + " Alumnos después de eliminar");

    }

}

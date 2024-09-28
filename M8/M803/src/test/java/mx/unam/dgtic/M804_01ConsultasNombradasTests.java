package mx.unam.dgtic;

import mx.unam.dgtic.datos.AlumnoNamedQueryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
public class M804_01ConsultasNombradasTests {

    final String ALUMNO = "FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ";
    private static final String NOMBRE = "CARLOS DAVID";
    private static final String PATERNO = "PEREZ";
    private static final double ESTATURA = 1.6;
    private static final String FECHA = "1991-02-01";

    @Autowired
    //private AlumnoRepository repositorioAlumno;
    private AlumnoNamedQueryRepository repositorioAlumno;

    @Test
    void buscarNamedQueryTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar altos");
        repositorioAlumno.buscarAltos().forEach(System.out::println);
        Date fecha = Date.valueOf(FECHA);
        System.out.println("Buscar Altos después de fecha");
        repositorioAlumno.buscarAltosConFecha(fecha).forEach(System.out::println);
        System.out.println("Buscar por nombre y paterno");
        repositorioAlumno.buscarPorNombreYPaterno(NOMBRE, PATERNO).forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"NSR","LMR", "MDF"})
    void buscarPorCurpContenga(String substring) {
        System.out.println(ALUMNO);
        System.out.println("Buscar por Curp contega: " + substring);
        System.out.println("Coinciden " + repositorioAlumno.contarPorCurpContenga(substring) + " Alumnos");
        repositorioAlumno.buscarPorCurpContenga(substring).forEach(System.out::println);
    }

    @ParameterizedTest
    @CsvSource({
            "DF, Ciudad de México",
            "NL, Nuevo León",
            "QT, Querétaro",
            "GT, Guanajuato",
            "GR, Guerrero"
    })
    void buscarPorCurpEstadoTest(String codigoEstado, String nombreEstado) {
        System.out.println(ALUMNO);
        System.out.println("Buscar por Curp estado: " + nombreEstado);
        System.out.println("Alumnos nacidos en " + nombreEstado + " "
                + repositorioAlumno.contarPorEstadoCurp(codigoEstado));
        repositorioAlumno.buscarPorEstadoCurp(codigoEstado).forEach(alumno -> {
            System.out.println(alumno.getCurp() + " " + alumno.getNombre() + " " + alumno.getPaterno());
        });
    }

    @Test
    void buscarEstaturasTest() {
        double estaturafin = 1.68;
        System.out.println(ALUMNO);
        System.out.println("Alumnos NOT Between estatura " + ESTATURA + " y " + estaturafin);
        repositorioAlumno.searchByEstaturaNotBetweenOrderByEstatura(ESTATURA, estaturafin)
                .forEach(alumno -> {
                    System.out.println(
                            alumno.getEstatura() + " "
                            + alumno.getNombre() +
                            " " + alumno.getPaterno()
                    );
                });
        System.out.println("Estatura Promedio " + repositorioAlumno.leerEstaturaPromedio());
        System.out.println("Alumnos más altos que la estatura promedio");
        repositorioAlumno.buscarAltosMayorPromedio()
                .forEach(alumno -> {
                    System.out.println(
                            alumno.getEstatura() + " "
                                    + alumno.getNombre() +
                                    " " + alumno.getPaterno()
                    );
                });
    }

    @ParameterizedTest
    @CsvSource({
            "'^.{10}M.{7}$', 'Buscar Mujeres'",   // CURP para mujeres (dígito 11 es "M")
            "'^.{10}H.{7}$', 'Buscar Hombres'",    // CURP para hombres (dígito 11 es "H")
            "'^(?![A-Z]{4}\\d{6}[HM][A-Z]{5}\\d{2}).*$', 'CURP no válidos'", // CURP no válidos
            "'^[A-Z]{4}\\d{6}[HM](?!QT|DF)[A-Z]{5}\\d{2}$', 'No son de QT ni DF'"  // No pertenecen a QT ni DF
    })
    void buscarCurpRegexTest(String regex, String descripcion) {
        System.out.println(ALUMNO);
        System.out.println("Expresión Regular: " + regex);
        System.out.println("Resultados para " + descripcion);
        repositorioAlumno.findByCurpRegex(regex).forEach(
                alumno -> System.out.println(alumno.getCurp()
                        + " " + alumno.getNombre() +
                        " " + alumno.getPaterno())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ROXANA GUTIERREZ",
            "GUTIERREZ ROXANA",
            "ROXANA",
            "GUTIERREZ",
            "MIGUEL GUTIERREZ",
            "ANGEL GUTIERREZ"
    })
    void buscarCombinacionNombrePaternoTest(String combinacion) {
        System.out.println(ALUMNO);
        System.out.println("Buscar combinación " + combinacion);
        repositorioAlumno.buscarPorCombinacionNombrePaterno(combinacion)
                .forEach(alumno -> {
                    System.out.println(alumno.getNombre() + " " + alumno.getPaterno());
                });
    }

    @Test
    void buscarDistinctNombrePaterno() {
        System.out.println("\n==============================");
        System.out.println("Alumno: " + ALUMNO);
        System.out.println("Prueba: Búsqueda de nombres y apellidos únicos");
        System.out.println("==============================");

        // Imprimir nombres únicos
        System.out.println("\n--- Lista de Nombres Únicos ---");
        repositorioAlumno.findDistinctNombre()
                .forEach(nombre -> System.out.println(" • " + nombre));

        // Imprimir apellidos paternos únicos
        System.out.println("\n--- Lista de Apellidos Paternos Únicos ---");
        repositorioAlumno.findDistinctPaterno()
                .forEach(paterno -> System.out.println(" • " + paterno));

        // Imprimir combinaciones únicas de nombre y apellido paterno
        System.out.println("\n--- Lista de Combinaciones Únicas de Nombre y Apellido Paterno ---");
        repositorioAlumno.findDistinctNombrePaterno()
                .forEach(combinacion -> System.out.println(" • " + combinacion));

        System.out.println("\n==============================\n");
    }

    @Test
    void contarPorCamposTest() {
        System.out.println(ALUMNO);

        System.out.println("Contar por nombre:");
        repositorioAlumno.contarPorNombre().forEach(
                cp -> System.out.println(cp.getCampo() + " " + cp.getConteo())
        );

        System.out.println(ALUMNO);
        System.out.println("Contar por paterno:");
        repositorioAlumno.contarPorPaterno().forEach(
                cp -> System.out.println(cp.getCampo() + " " + cp.getConteo())
        );

        System.out.println(ALUMNO);
        System.out.println("Contar por Año:");
        repositorioAlumno.contarPorAnio().forEach(
                cp -> System.out.println(cp.getCampo() + " " + cp.getConteo())
        );

        System.out.println(ALUMNO);
        System.out.println("Contar por Sexo:");
        repositorioAlumno.contarPorSexo().forEach(
                cp -> System.out.println(cp.getCampo() + " " + cp.getConteo())
        );

        System.out.println(ALUMNO);
        System.out.println("Contar por Estado:");
        repositorioAlumno.contarPorEstado().forEach(
                cp -> System.out.println(cp.getCampo() + " " + cp.getConteo())
        );
    }



}

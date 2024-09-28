package mx.unam.dgtic;

import mx.unam.dgtic.datos.AlumnoNamedQueryRepository;
import mx.unam.dgtic.datos.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Arrays;

@SpringBootTest
public class M803_03ConsultasNombradasTests {

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
    }
}

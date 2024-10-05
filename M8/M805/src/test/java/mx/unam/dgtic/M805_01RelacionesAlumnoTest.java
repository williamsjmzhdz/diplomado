package mx.unam.dgtic;

import mx.unam.dgtic.datos.AlumnoRepository;
import mx.unam.dgtic.datos.Estado;
import mx.unam.dgtic.datos.EstadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class M805_01RelacionesAlumnoTest {

    final String ALUMNO = "FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ";
    final String ESTADO = "Guerrero";

    @Autowired
    AlumnoRepository repositorioAlumno;

    @Autowired
    EstadoRepository repositorioEstado;

    @Transactional
    @Test
    void buscarPorEstadoTest() {
        System.out.println(ALUMNO);

        System.out.println("Estado");
        Estado estado = repositorioEstado.findByEstado(ESTADO);
        System.out.println(estado);
        System.out.println("Alumnos en el estado " + estado.getEstado());
        estado.getAlumnos().forEach(alumno -> System.out.println(
                alumno.getNombre() + " " + alumno.getPaterno() + " " +
                        alumno.getEstado().getAbreviatura()
        ));

        System.out.println("Buscar Alumnos por Objeto ESTADO");
        repositorioAlumno.findByEstado(estado).forEach(System.out::println);

        System.out.println("Buscar Alumnos por la cadena ESTADO " + ESTADO);
        repositorioAlumno.findByEstadoEstado(ESTADO).forEach(System.out::println);

        System.out.println("Buscar Alumnos por Abreviatura de Estado CDMX");
        repositorioAlumno.findByEstadoAbreviatura("CDMX").forEach(System.out::println);
    }

    @Test
    void findEstadoTest() {
        System.out.println(ALUMNO);
        System.out.println("Estados que no tienen ningún Alumno");
        repositorioEstado.findEstadosSinAlumnos().forEach(System.out::println);

        System.out.println("Estados con al menos 2 alumnos");
        repositorioEstado.findEstadosConMinimoAlumnos(2).forEach(System.out::println);

        System.out.println(ALUMNO);
        System.out.println("Número de Alumnos por Estado");
        List<Object[]> resultado = repositorioEstado.findEstadoAlumnosCount();
        for (Object[] r : resultado) {
            Estado estado = (Estado) r[0];
            Long conteoAlu = (Long) r[1];
            System.out.println("Estado " + estado.getEstado() + ", Número de Alumnos " + conteoAlu);
        }
    }

}

package mx.unam.dgtic;

import mx.unam.dgtic.datos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class M805_02AlumnosCalificacionesTest {

    final String ALUMNO = "FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ";
    private static final String MATERIA = "BD";
    private static final int CALIFICACION = 8;
    private static final String NOMBRE = "Perla";
    private static final String PATERNO = "Perez";
    private static final int ID_ESTADO = 10;

    @Autowired
    AlumnoRepository repositorioAlumno;

    @Autowired
    CalificacionRepository repositorioCalificacion;

    @Autowired
    EstadoRepository repositorioEstado;

    @Test
    void buscarAlumnosCalificacionesTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar todos los alumnos con sus calificaciones");

        repositorioAlumno.buscarTodosConCalificaciones().forEach(alumno -> {
            System.out.println("--- Alumno ---");
            System.out.println(alumno.getNombre() + " " + alumno.getPaterno() + " " +
                    alumno.getEstado().getEstado());
            alumno.getCalificaciones().forEach(calificacion -> {
                System.out.println(calificacion.getMateria() + " " + calificacion.getCalificacion());
            });
        });
    }

    @Test
    void buscarCalificacionesAlumnoTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar todas las calificaciones y sus Alumnos");
        repositorioCalificacion.findAll().forEach(calificacion -> {
            System.out.println("Materia " + calificacion.getMateria() + ", "
                    + "Calificación " + calificacion.getCalificacion() + ", "
                    + "Alumno " + calificacion.getAlumno().getNombre() + " " + calificacion.getAlumno()
                    .getPaterno() + " " + calificacion.getAlumno().getEstado().getAbreviatura());
        });
    }

    @Test
    void insertarCalificacionesTest() {
        System.out.println(ALUMNO);
        System.out.println("Insertar Calificaciones");
        System.out.println("1. Insertar Alumno");
        Alumno alumno = new Alumno("1F", "WILLIAMS", "JIMÉNEZ", new Date(), 1.68);
        alumno.setEstado(repositorioEstado.findById(ID_ESTADO).get());
        repositorioAlumno.save(alumno);
        Optional<Alumno> optional = repositorioAlumno.findById("1F");
        if (optional.isPresent()) {
            System.out.println(optional.get());
            System.out.println("Insertar calificaciones");
            Calificacion c = new Calificacion(11, MATERIA, CALIFICACION, optional.get());
            repositorioCalificacion.save(c);
            c = new Calificacion(12, "Java", CALIFICACION, optional.get());
            repositorioCalificacion.save(c);
        } else {
            System.out.println("Matricula 1F no localizada.");
        }
    }

}

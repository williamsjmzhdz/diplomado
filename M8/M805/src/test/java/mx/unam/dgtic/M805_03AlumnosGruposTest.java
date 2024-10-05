package mx.unam.dgtic;

import mx.unam.dgtic.datos.Alumno;
import mx.unam.dgtic.datos.AlumnoRepository;
import mx.unam.dgtic.datos.GrupoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
public class M805_03AlumnosGruposTest {

    final String ALUMNO = "FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ";
    final String MATRICULA = "1A";

    @Autowired
    AlumnoRepository repositorioAlumno;

    @Autowired
    GrupoRepository repositorioGrupo;

    @Test
    @Transactional
    void buscarGruposPorAlumnoTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar grupos por Alumno");

        repositorioAlumno.findAll().forEach(alumno -> {
            System.out.println(alumno.getMatricula() + " " + alumno.getNombre() + " " +
                    alumno.getPaterno() + " " + alumno.getEstado().getAbreviatura());
            alumno.getGrupos().forEach(grupo -> {
                System.out.println("Id Grupo " + grupo.getId() + " Grupo " + grupo.getGrupo());
            });
        });
    }

    @Test
    @Transactional
    void buscarAlumnosPorGrupoTest() {
        System.out.println(ALUMNO);
        System.out.println("Buscar Alumnos por Grupo");
        repositorioGrupo.findAll().forEach(grupo -> {
            System.out.println(grupo.getId() + " " + grupo.getGrupo());
            grupo.getAlumnos().forEach(alumno -> {
                System.out.println(alumno.getMatricula() + " " + alumno.getNombre() + " " +
                        alumno.getPaterno() + " " + alumno.getEstado().getAbreviatura());
            });
        });
    }

    @Test
    @Transactional
    void buscarGruposPorMatricula() {
        System.out.println(ALUMNO);
        System.out.println("Buscar Grupos por Matricula");
        repositorioAlumno.findGruposByMatricula(MATRICULA).forEach(System.out::println);
    }

    @Test
    @Transactional
    void agregarEliminarAlumnoGrupo() {
        System.out.println(ALUMNO);
        Optional<Alumno> optional = repositorioAlumno.findById("1F");
        Alumno a = optional.get();
        a.addGrupo(repositorioGrupo.findById(1).get());
        a.addGrupo(repositorioGrupo.findById(3).get());

        repositorioAlumno.save(a);

        repositorioAlumno.findGruposByMatricula("1F").forEach(System.out::println);

        System.out.println("Remover Alumno de Grupo");
        a.removeGrupo(repositorioGrupo.findById(3).get());
        repositorioAlumno.save(a);

        repositorioAlumno.findGruposByMatricula("1F").forEach(System.out::println);

    }

}

package mx.unam.dgtic;

import mx.unam.dgtic.datos.Alumno;
import mx.unam.dgtic.datos.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
public class M0801_02ApplicationTestsCrudDatos {
    final String ALUMNO = "FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ";
    final String MATRICULA = "1F";

    @Autowired
    AlumnoRepository repositorioAlumno;

    @Test
    void insertarUnoTest() {
        System.out.println(ALUMNO);
        System.out.println("Insertar Alumno");

        LocalDate fechaLocal = LocalDate.of(1998, 5, 14);
        Date fecha = Date.from(fechaLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Alumno alumno = new Alumno(MATRICULA, "WILLIAMS", "JIMÉNEZ", fecha, 1.65);
        repositorioAlumno.save(alumno);

        Optional<Alumno> optional = repositorioAlumno.findById(MATRICULA);
        if (optional.isPresent()) {
            System.out.println("Recuperar alumno desde la BD");
            System.out.println(optional.get());
        } else {
            System.out.println("Matrícula " + MATRICULA + " no localizada");
        }
    }

    @Test
    void editarUnoTest() {
        System.out.println(ALUMNO);
        System.out.println("Editar Alumno");

        Optional<Alumno> optional = repositorioAlumno.findById(MATRICULA);

        if (optional.isPresent()) {
            Alumno alumno = optional.get();
            System.out.println("Alumno antes de actualizar");
            System.out.println(alumno);

            alumno.setPaterno("JIMÉNEZ HERNÁNDEZ");
            alumno.setEstatura(1.68);
            try {
                alumno.setFnac(new SimpleDateFormat("yyyy-MM-dd")
                        .parse("1999-08-24"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            repositorioAlumno.save(alumno);
            System.out.println("Alumno después de la actualización");
            System.out.println(repositorioAlumno.findById(MATRICULA).get());
        } else {
            System.out.println("Matrícula " + MATRICULA + " no localizada");
        }
    }


    @Test
    void eliminarUnoTest() {
        System.out.println(ALUMNO);
        System.out.println("Eliminar Alumno");

        Optional<Alumno> optional = repositorioAlumno.findById(MATRICULA);
        if (optional.isPresent()) {
            System.out.println("Alumno antes de la eliminación");
            System.out.println(optional.get());
            repositorioAlumno.delete(optional.get());
        } else {
            System.out.println("Matrícula " + MATRICULA + " no localizada");
        }

        System.out.println("Eliminar alumno por id");
        repositorioAlumno.deleteById("1A");

        System.out.println("Alumnos en la BD");
        repositorioAlumno.findAll().forEach(System.out::println);
    }

    @Test
    void eliminarUnoDinamicoTest() {
        System.out.println(ALUMNO);
        System.out.println("Eliminar Alumno Dinámico");

        Scanner entrada = new Scanner(System.in);
        String matricula = entrada.nextLine();

        Optional<Alumno> optional = repositorioAlumno.findById(matricula);
        if (optional.isPresent()) {
            System.out.println("Alumno antes de la eliminación");
            System.out.println(optional.get());
            repositorioAlumno.deleteById(matricula);
            System.out.println("Alumno con Matrícula " + matricula + " ha sido eliminado.");
        } else {
            System.out.println("Matrícula " + matricula + " no localizada");
        }
    }

    @Test
    void insertarVariosTest() {
        System.out.println(ALUMNO);
        System.out.println("Insertar Varios Alumnos");
        List<Alumno> alumnos = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            alumnos.add(new Alumno(
                    i + "M",
                    "Marco " + i,
                    "Polo " + i,
                    new Date(),
                    1.65));
        }
        System.out.println("Existen " + repositorioAlumno.count() + " alumnos antes de la inserción");
        repositorioAlumno.saveAll(alumnos);
        System.out.println("Existen " + repositorioAlumno.count() + " alumnos después de la inserción");
        System.out.println("Alumnos en la BD");
        repositorioAlumno.findAll().forEach(System.out::println);
    }

    @Test
    void eliminarVariosTest() {
        System.out.println(ALUMNO);
        System.out.println("Eliminar Varios alumnos");

        List<String> matriculas = IntStream.range(1, 6).mapToObj(i -> i + "M").collect(Collectors.toList());
        System.out.println(matriculas);

        System.out.println("Existen " + repositorioAlumno.count() + " alumnos antes de la eliminación");
        repositorioAlumno.deleteAllById(matriculas);
        System.out.println("Existen " + repositorioAlumno.count() + " alumnos después de la eliminación");
        System.out.println("Alumnos en la BD");
        repositorioAlumno.findAll().forEach(System.out::println);
    }

}

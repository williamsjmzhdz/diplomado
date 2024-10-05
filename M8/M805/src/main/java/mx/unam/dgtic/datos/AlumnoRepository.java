package mx.unam.dgtic.datos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlumnoRepository extends CrudRepository<Alumno, String> {

    List<Alumno> findByEstado(Estado estado);

    long countByEstado(Estado estado);

    // Encontrar alumnos por el nombre del estado
    List<Alumno> findByEstadoEstado(String estado);

    // Encontrar alumnos por la abreviatura del estado
    List<Alumno> findByEstadoAbreviatura(String abreviatura);

    List<Alumno> buscarTodosConCalificaciones();

    @Query("SELECT g FROM Alumno a JOIN a.grupos g WHERE a.matricula = :matricula")
    List<Grupo> findGruposByMatricula(@Param("matricula") String matricula);

}

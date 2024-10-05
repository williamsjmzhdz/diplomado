package mx.unam.dgtic.datos;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CalificacionRepository extends CrudRepository<Calificacion, Integer> {

    List<Calificacion> findByMateria(String materia);

    List<Calificacion> findByCalificacion(Integer calificacion);

    List<Calificacion> findByAlumnoNombre(String nombre);

    List<Calificacion> findByAlumnoPaterno(String paterno);

    List<Calificacion> findByAlumnoPaternoLike(String patron);

}

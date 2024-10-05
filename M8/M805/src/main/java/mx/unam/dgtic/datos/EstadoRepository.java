package mx.unam.dgtic.datos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstadoRepository extends CrudRepository<Estado, Integer> {

    // Encontrar un estado por el nombre del estado
    Estado findByEstado(String estado);

    // Encontrar estados cuyo nombre contenga un str
    List<Estado> findByEstadoContaining(String str);

    // Cuenta el número de alumnos por estado
    @Query("SELECT e, COUNT(a) FROM Estado e LEFT JOIN e.alumnos a GROUP BY e")
    List<Object[]> findEstadoAlumnosCount();

    // Muestra una lista de estados únicos que tienen alumnos con un nombre específico.
    @Query("SELECT DISTINCT e FROM Estado e JOIN e.alumnos a WHERE a.nombre LIKE %:nombre%")
    List<Estado> findEstadoByAlumnoNombreLike(String nombre);

    // Busca estados sin alumnos
    @Query("SELECT e FROM Estado e WHERE e.alumnos IS EMPTY")
    List<Estado> findEstadosSinAlumnos();

    // Busca estados con al menos un mínimo de alumnos
    @Query("SELECT e FROM Estado e WHERE SIZE(e.alumnos) >= :minimo")
    List<Estado> findEstadosConMinimoAlumnos(int minimo);

}

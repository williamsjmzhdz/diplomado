package mx.unam.dgtic.datos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AlumnoNamedQueryRepository extends CrudRepository<Alumno, String> {

    List<Alumno> buscarAltos();
    List<Alumno> buscarAltosConFecha(@Param("fecha") Date fecha);
    List<Alumno> buscarPorNombre(String nombre);
    List<Alumno> buscarPorNombreYPaterno(String nombre, String paterno);

    @Query(value = "SELECT avg(a.estatura) FROM Alumno a")
    double leerEstaturaPromedio();

}

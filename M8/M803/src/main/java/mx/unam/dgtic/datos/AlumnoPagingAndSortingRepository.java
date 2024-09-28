package mx.unam.dgtic.datos;

import mx.unam.dgtic.datos.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface AlumnoPagingAndSortingRepository extends PagingAndSortingRepository<Alumno, String> {

    // Consulta derivada Paginada
    Page<Alumno> findByCurpLike(String patron, Pageable pagina);

    Page<Alumno> findByCurpNotLike(String patron, Pageable pagina);

    // Consulta Nombrada Paginada
    @Query(value = "SELECT DISTINCT a.nombre FROM Alumno a")
    Page<String> findDistinctNombre(Pageable pagina);

    @Query(value = "SELECT DISTINCT a.paterno FROM Alumno a")
    Page<String> findDistinctPaterno(Pageable pagina);

    @Query(value = "SELECT a.nombre AS campo, COUNT(*) AS conteo " +
            "FROM Alumno a " +
            "GROUP BY a.nombre")
    Page<ConteoPorCampo> contarPorNombre(Pageable pagina);

    @Query(
            nativeQuery = true,
            value = "SELECT SUBSTRING(a.curp, 11, 1) AS campo, COUNT(*) AS conteo " +
            "FROM Alumnos a " +
            "GROUP BY campo")
    Page<ConteoPorCampo> contarPorSexo(Pageable pagina);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM Alumnos " +
                    "WHERE CONCAT(nombre, ' ', paterno) LIKE %?1% " +
                    "OR CONCAT(paterno, ' ', nombre) LIKE %?1% " +
                    "OR CONCAT(SUBSTRING_INDEX(nombre, ' ', 1), ' ', paterno) LIKE %?1% " +
                    "OR CONCAT(SUBSTRING_INDEX(paterno, ' ', -1), ' ', nombre) LIKE %?1%"
    )
    List<Alumno> buscarPorCombinacionNombrePaterno(String combinacion, Pageable pagina);
}

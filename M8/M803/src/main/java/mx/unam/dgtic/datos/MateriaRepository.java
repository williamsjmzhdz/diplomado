package mx.unam.dgtic.datos;

import mx.unam.dgtic.datos.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Autor: Jiménez Hernández Francisco Williams
 * Fecha de realización: 28 de septiembre de 2024
 */
public interface MateriaRepository extends PagingAndSortingRepository<Materia, String> {

    // Métodos de búsqueda con consultas derivadas para la entidad Materia
    List<Materia> findByMateria(String materia);
    List<Materia> findByCreditos(int creditos);
    List<Materia> findByHorasGreaterThan(int horas);
    List<Materia> findByCreditosLessThanEqual(int creditos);
    List<Materia> findByMateriaContaining(String partialMateria);

    // Consultas JPQL nombradas
    List<Materia> buscarPorCreditosMayores(@Param("creditos") int creditos);
    List<Materia> buscarPorHoras(@Param("horas") int horas);
    List<Materia> buscarPorMateriaContiene(@Param("nombre") String nombre);

    // Consultas SQL nombradas
    List<Materia> buscarMateriasConMasHorasPromedio();
    long contarMateriasPorCreditos(@Param("creditos") int creditos);

    // Paginación
    Page<Materia> findAll(Pageable pageable);

    // Método para obtener todas las materias ordenadas por un campo
    Iterable<Materia> findAll(Sort sort);
}

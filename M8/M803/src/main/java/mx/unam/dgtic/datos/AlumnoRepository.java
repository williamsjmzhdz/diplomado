package mx.unam.dgtic.datos;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

// FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ
public interface AlumnoRepository extends CrudRepository<Alumno, String> {
    //List<Alumno> searchByNombre(String nombre);
    //List<Alumno> queryByNombre(String nombre);
    //List<Alumno> readByNombre(String nombre);
    //List<Alumno> getByNombre(String nombre);
    //List<Alumno> getByNombreNot(String nombre);

    // Metodos de busqueda con consultas derivadas
    List<Alumno> findByNombre(String nombre);
    List<Alumno> findByNombreNot(String nombre);
    List<Alumno> readByPaterno(String paterno);
    List<Alumno> readByEstatura(Double estatura);
    List<Alumno> readByFnac(Date fnac);
    List<Alumno> readByCurp(String curp);


    // Streams: requieren @Transanctional
    Stream<Alumno> streamByNombre(String nombre);
    Stream<Alumno> streamByNombreNot(String nombre);


    // Métodos count con consultas derivadas
    long countByNombre(String nombre);
    long countByNombreNot(String nombre);

    // Nulos
    List<Alumno> findByPaternoIsNull();
    List<Alumno> findByPaternoIsNotNull();
    long countByPaternoIsNull();
    long countByPaternoIsNotNull();

    // Operadores lógicos
    List<Alumno> queryByNombreAndPaterno(String nombre, String paterno);
    List<Alumno> queryByNombreOrPaterno(String nombre, String paterno);
    List<Alumno> queryByNombreOrPaternoNull(String nombre);
    List<Alumno> queryByNombreOrPaternoNotNull(String nombre);
    List<Alumno> queryByNombreOrPaternoAndEstatura(String nombre, String paterno, double estatura);

    long countByNombreAndPaterno(String nombre, String paterno);
    long countByNombreOrPaterno(String nombre, String paterno);

    boolean existsByNombreAndPaterno(String nombre, String paterno);
    boolean existsByNombreOrPaterno(String nombre, String paterno);

    // Limitar consultas
    List<Alumno> readFirstByEstatura(double estatura);
    List<Alumno> readTopByEstatura(double estatura);
    List<Alumno> readTop1ByEstatura(double estatura);
    List<Alumno> readTop3ByEstatura(double estatura);
    List<Alumno> readTop3ByEstaturaOrderByNombreDesc(double estatura);
    List<Alumno> findByNombreOrderByPaternoAsc(String nombre);
    List<Alumno> findByNombreOrderByPaternoDesc(String nombre);
    List<Alumno> readFirstByNombre(String nombre);
    List<Alumno> readTop2ByNombreOrderByPaternoAsc(String nombre);
    List<Alumno> readTop2ByNombreOrderByPaternoDesc(String nombre);

    // Operadores
    // In
    List<Alumno> searchByEstaturaIn(Collection<Double> estaturas);
    List<Alumno> searchByEstaturaNotIn(Collection<Double> estaturas);
    List<Alumno> searchByNombreIn(Collection<String> nombres);
    //List<Alumno> searchByNombreNotIn(Collection<String> nombres);

    // Between
    List<Alumno> searchByEstaturaBetweenOrderByEstatura(double estaturaini, double estaturafin);
    //List<Alumno> searchByEstaturaNotBetweenOrderByEstatura(double estaturaini, double estaturafin);
    List<Alumno> searchByNombreBetweenOrderByNombre(String nombreini, String nombrefin);
    //List<Alumno> searchByNombreNotBetweenOrderByNombre(String nombreini, String nombrefin);

    // Mayor qué, Menor qué
    List<Alumno> queryByFnacBefore(Date fecha);
    List<Alumno> queryByFnacAfter(Date fecha);
    List<Alumno> queryByEstaturaLessThan(double estatura);
    List<Alumno> queryByEstaturaLessThanEqual(double estatura);
    List<Alumno> queryByEstaturaGreaterThan(double estatura);
    List<Alumno> queryByEstaturaGreaterThanEqual(double estatura);

    // Patrones
    List<Alumno> findByNombreStartingWith(String inicia);
    List<Alumno> findByNombreContaining(String contiene);
    List<Alumno> findByNombreEndingWith(String termina);

    // Like
    List<Alumno> findByNombreLike(String patron);
    List<Alumno> findByNombreNotLike(String patron);
    long countByNombreLike(String patron);
    long countByNombreNotLike(String patron);

    // Eliminar
    @Transactional
    List<Alumno> deleteByNombreLike(String patron);

}

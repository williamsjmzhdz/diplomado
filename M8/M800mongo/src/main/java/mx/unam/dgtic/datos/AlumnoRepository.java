package mx.unam.dgtic.datos;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlumnoRepository extends MongoRepository<Alumno, String> {
}

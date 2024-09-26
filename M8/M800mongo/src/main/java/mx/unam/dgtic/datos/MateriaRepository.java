package mx.unam.dgtic.datos;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MateriaRepository extends MongoRepository<Materia, String> {
}

package unam.diplomado.pixup.usuario.repository;

import unam.diplomado.pixup.usuario.domain.Colonia;

import java.util.List;
import java.util.Optional;

public interface ColoniaRepository {
    List<Colonia> ListfindByCp(String cp);
    Optional<Colonia> findById(Integer id);
    Colonia saveOrUpdate(Colonia colonia);
    void delete(Colonia colonia);
    Optional<Colonia> findByCpAndNombre(String cp, String nombre);
}

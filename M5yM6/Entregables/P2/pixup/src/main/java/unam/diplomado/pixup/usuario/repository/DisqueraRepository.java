package unam.diplomado.pixup.usuario.repository;

import unam.diplomado.pixup.usuario.domain.Disquera;

import java.util.Optional;

public interface DisqueraRepository {
    Optional<Disquera> findById(Integer id);
}

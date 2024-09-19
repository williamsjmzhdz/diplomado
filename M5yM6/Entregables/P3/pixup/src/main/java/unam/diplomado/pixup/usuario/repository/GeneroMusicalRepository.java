package unam.diplomado.pixup.usuario.repository;

import unam.diplomado.pixup.usuario.domain.GeneroMusical;

import java.util.Optional;

public interface GeneroMusicalRepository {
    Optional<GeneroMusical> findById(Integer id);
}

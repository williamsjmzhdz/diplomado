package unam.diplomado.pixup.usuario.repository;

import unam.diplomado.pixup.usuario.domain.Artista;

import java.util.Optional;

public interface ArtistaRepository {
    Optional<Artista> findById(Integer id);
}

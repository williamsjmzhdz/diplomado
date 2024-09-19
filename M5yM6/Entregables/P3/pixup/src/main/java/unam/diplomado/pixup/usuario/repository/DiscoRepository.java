package unam.diplomado.pixup.usuario.repository;

import unam.diplomado.pixup.usuario.domain.Disco;

import java.util.Optional;

public interface DiscoRepository {
    Optional<Disco> findByTituloAndArtista(String titulo, Integer idArtista);
    Disco save(Disco disco);
}

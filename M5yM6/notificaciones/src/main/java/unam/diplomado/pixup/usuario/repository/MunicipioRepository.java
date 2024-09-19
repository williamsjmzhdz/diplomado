package unam.diplomado.pixup.usuario.repository;

import unam.diplomado.pixup.usuario.domain.Municipio;

import java.util.Optional;

public interface MunicipioRepository {

    Optional<Municipio> findById(Integer id);

}

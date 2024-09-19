package unam.diplomado.pixup.usuario.service;

import jakarta.ejb.Local;
import unam.diplomado.pixup.usuario.domain.Disco;

@Local
public interface DiscoService {
    Disco registrarDisco(Disco disco);
}

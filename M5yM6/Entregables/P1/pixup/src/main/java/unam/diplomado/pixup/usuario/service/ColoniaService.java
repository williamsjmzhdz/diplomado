package unam.diplomado.pixup.usuario.service;

import jakarta.ejb.Local;
import unam.diplomado.pixup.usuario.domain.Colonia;

@Local
public interface ColoniaService {
    Colonia obtenerColoniaPorId(Integer id);
    Colonia crearColonia(Colonia colonia);
    void eliminarColoniaPorId(Integer id);
}

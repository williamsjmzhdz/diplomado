package dgtic.core.service.caladero;

import dgtic.core.model.entities.CaladeroEntity;
import dgtic.core.model.entities.CompraEntity;
import dgtic.core.model.entities.CompradorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CaladeroService {
    Page<CaladeroEntity> buscarCaladero(Pageable pageable);
    List<CaladeroEntity> buscarCaladero();
    void guardar(CaladeroEntity caladeroEntity);
    void borrar(Integer id);
    CaladeroEntity buscarCaladeroId(Integer id);
    List<CaladeroEntity> buscarCaladeroPatron(String patron);
}

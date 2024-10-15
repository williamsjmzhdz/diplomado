package dgtic.core.service.caladero;

import dgtic.core.model.entities.CaladeroEntity;
import dgtic.core.model.entities.CompradorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CaladeroService {

    Page<CaladeroEntity> buscarCaladero(Pageable pageable);
    void guardar(CaladeroEntity caladeroEntity);
    void borrar(Integer id);
    CaladeroEntity buscarPorId(Integer id);

}

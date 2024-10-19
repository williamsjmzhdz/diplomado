package dgtic.core.service.barco;

import dgtic.core.model.entities.BarcoEntity;
import dgtic.core.model.entities.CaladeroEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BarcoService {
    Page<BarcoEntity> buscarBarco(Pageable pageable);
    List<BarcoEntity> buscarBarco();
    void guardar(BarcoEntity barcoEntity);
    void borrar(Integer id);
    BarcoEntity buscarBarcoId(Integer id);
    List<BarcoEntity> buscarBarcoPatron(String patron);
}

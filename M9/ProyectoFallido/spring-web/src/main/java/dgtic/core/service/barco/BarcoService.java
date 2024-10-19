package dgtic.core.service.barco;

import dgtic.core.model.entities.BarcoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BarcoService {

    Page<BarcoEntity> buscarBarco(Pageable pageable);
    void guardar(BarcoEntity barcoEntity);
    void borrar(Integer id);
    BarcoEntity buscarPorId(Integer id);

}

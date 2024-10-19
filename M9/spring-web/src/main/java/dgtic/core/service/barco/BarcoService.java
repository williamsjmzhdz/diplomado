package dgtic.core.service.barco;

import dgtic.core.model.entities.BarcoEntity;
import dgtic.core.model.entities.EspecieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BarcoService {

    Page<BarcoEntity> buscarBarco(Pageable pageable);
    void guardar(BarcoEntity barcoEntity);
    void borrar(Integer id);
    BarcoEntity buscarPorId(Integer id);
    List<BarcoEntity> buscarBarco();

}

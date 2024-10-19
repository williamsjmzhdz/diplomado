package dgtic.core.service.captura;

import dgtic.core.model.entities.CapturaEntity;
import dgtic.core.model.entities.CompraEntity;
import dgtic.core.model.entities.CompradorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CapturaService {
    Page<CapturaEntity> buscarCaptura(Pageable pageable);
    List<CapturaEntity> buscarCaptura();
    void guardar(CapturaEntity capturaEntity);
    void borrar(Integer id);
    CapturaEntity buscarCapturaId(Integer id);
    List<CapturaEntity> buscarCapturaPatron(String patron);
}

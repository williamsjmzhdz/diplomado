package dgtic.core.service.lote;

import dgtic.core.model.entities.LoteEntity;
import dgtic.core.model.entities.TipoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LoteService {
    Page<LoteEntity> buscarLote(Pageable pageable);
    void guardar(LoteEntity loteEntity);
    void borrar(Integer id);
    LoteEntity buscarLoteId(Integer id);

    List<LoteEntity> lotes();
}

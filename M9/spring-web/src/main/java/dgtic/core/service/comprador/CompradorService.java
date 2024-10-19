package dgtic.core.service.comprador;

import dgtic.core.model.entities.CompradorEntity;
import dgtic.core.model.entities.LoteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompradorService {
    Page<CompradorEntity> buscarcomprador(Pageable pageable);
    void guardar(CompradorEntity compradorEntity);
    void borrar(Integer id);
    CompradorEntity buscarCompradorId(Integer id);
}

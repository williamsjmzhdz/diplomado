package dgtic.core.service.comprador;

import dgtic.core.model.entities.CompradorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompradorService {

    Page<CompradorEntity> buscarComprador(Pageable pageable);
    void guardar(CompradorEntity compradorEntity);
    void borrar(Integer id);
    CompradorEntity buscarPorId(Integer id);

}

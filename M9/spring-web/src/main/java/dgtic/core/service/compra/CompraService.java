package dgtic.core.service.compra;

import dgtic.core.model.entities.CompraEntity;
import dgtic.core.model.entities.CompradorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompraService {
    Page<CompraEntity> buscarCompra(Pageable pageable);
    List<CompraEntity> buscarCompra();
    void guardar(CompraEntity compraEntity);
    void borrar(Integer id);
    CompraEntity buscarCompraId(Integer id);
    List<CompradorEntity> buscarCompraPatron(String patron);
}

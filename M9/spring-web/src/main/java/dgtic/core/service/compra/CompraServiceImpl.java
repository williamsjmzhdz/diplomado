package dgtic.core.service.compra;

import dgtic.core.model.entities.CompraEntity;
import dgtic.core.model.entities.CompradorEntity;
import dgtic.core.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService{
    @Autowired
    CompraRepository compraRepository;
    @Override
    @Transactional(readOnly = true)
    public Page<CompraEntity> buscarCompra(Pageable pageable) {
        return compraRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompraEntity> buscarCompra() {
        return compraRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(CompraEntity compraEntity) {
        compraRepository.save(compraEntity);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        compraRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CompraEntity buscarCompraId(Integer id) {
        Optional<CompraEntity> op=compraRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompradorEntity> buscarCompraPatron(String patron) {
        return null;
    }
}

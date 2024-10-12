package dgtic.core.service.lote;

import dgtic.core.model.entities.LoteEntity;
import dgtic.core.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LoteServiceImpl implements LoteService {
    @Autowired
    LoteRepository loteRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<LoteEntity> buscarLote(Pageable pageable) {
        return loteRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void guardar(LoteEntity loteEntity) {
        loteRepository.save(loteEntity);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        loteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public LoteEntity buscarPorId(Integer id) {
        Optional<LoteEntity> op = loteRepository.findById(id);
        return op.orElse(null);
    }
}

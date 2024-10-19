package dgtic.core.service.tipo;

import dgtic.core.model.entities.TipoEntity;
import dgtic.core.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoServiceImpl implements TipoService {

    @Autowired
    TipoRepository tipoRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<TipoEntity> buscarTipo(Pageable pageable) {
        return tipoRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void guardar(TipoEntity tipoEntity) {
        tipoRepository.save(tipoEntity);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        tipoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public TipoEntity buscarPorId(Integer id) {
        Optional<TipoEntity> op = tipoRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    public List<TipoEntity> tipos() {
        return tipoRepository.findAll();
    }
}

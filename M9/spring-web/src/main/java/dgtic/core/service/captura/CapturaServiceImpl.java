package dgtic.core.service.captura;

import dgtic.core.model.entities.CapturaEntity;
import dgtic.core.repository.CapturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CapturaServiceImpl implements CapturaService{

    @Autowired
    CapturaRepository capturaRepository;
    @Override
    @Transactional(readOnly = true)
    public Page<CapturaEntity> buscarCaptura(Pageable pageable) {
        return capturaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CapturaEntity> buscarCaptura() {
        return capturaRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(CapturaEntity capturaEntity) {
        capturaRepository.save(capturaEntity);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        capturaRepository.deleteById(id);
    }

    @Override
    public CapturaEntity buscarCapturaId(Integer id) {
        Optional<CapturaEntity> op=capturaRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    public List<CapturaEntity> buscarCapturaPatron(String patron) {
        return null;
    }
}

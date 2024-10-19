package dgtic.core.service.comprador;

import dgtic.core.model.entities.CompradorEntity;
import dgtic.core.repository.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CompradorServiceImpl implements CompradorService {

    @Autowired
    private CompradorRepository compradorRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<CompradorEntity> buscarComprador(Pageable pageable) {
        return compradorRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void guardar(CompradorEntity compradorEntity) {
        compradorRepository.save(compradorEntity);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        compradorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CompradorEntity buscarPorId(Integer id) {
        Optional<CompradorEntity> optional = compradorRepository.findById(id);
        return optional.orElse(null);
    }
}

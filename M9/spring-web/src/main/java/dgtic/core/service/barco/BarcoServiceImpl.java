package dgtic.core.service.barco;

import dgtic.core.model.entities.BarcoEntity;
import dgtic.core.repository.BarcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BarcoServiceImpl implements BarcoService{
    @Autowired
    BarcoRepository barcoRepository;
    @Override
    @Transactional(readOnly = true)
    public Page<BarcoEntity> buscarBarco(Pageable pageable) {
        return barcoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BarcoEntity> buscarBarco() {
        return barcoRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(BarcoEntity barcoEntity) {
        barcoRepository.save(barcoEntity);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        barcoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public BarcoEntity buscarBarcoId(Integer id) {
        Optional<BarcoEntity> op=barcoRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    public List<BarcoEntity> buscarBarcoPatron(String patron) {
        return null;
    }

    /*
    @Override
    public List<BarcoEntity> buscarBarco() {
        return barcoRepository.findAll();
    }*/
}

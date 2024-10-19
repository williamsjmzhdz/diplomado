package dgtic.core.service.barco;

import dgtic.core.model.entities.BarcoEntity;
import dgtic.core.repository.BarcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BarcoServiceImpl implements BarcoService {

    @Autowired
    private BarcoRepository barcoRepository;

    @Override
    public Page<BarcoEntity> buscarBarco(Pageable pageable) {
        return barcoRepository.findAll(pageable);
    }

    @Override
    public void guardar(BarcoEntity barcoEntity) {
        barcoRepository.save(barcoEntity);
    }

    @Override
    public void borrar(Integer id) {
        barcoRepository.deleteById(id);
    }

    @Override
    public BarcoEntity buscarPorId(Integer id) {
        Optional<BarcoEntity> optional = barcoRepository.findById(id);
        return optional.orElse(null);
    }
}
